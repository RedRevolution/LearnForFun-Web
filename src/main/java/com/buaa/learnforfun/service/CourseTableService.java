package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.CourseMapper;
import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.SelectCourseMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.CourseExample;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.SelectCourseExample;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.util.AdminIdCreate;
import com.buaa.learnforfun.util.AnalyzeCourseInfo;
import com.buaa.learnforfun.util.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseTableService {
    @Autowired
    SelectCourseMapper selectCourseMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    UserGroupMapper userGroupMapper;

    public String importCourseTable(String userId, String usr, String pwd) {
        Spider spider = new Spider(usr, pwd);
        try {
            spider.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "failure";
        }
        List<String> courseCode = null;
        try {
            courseCode = importCourse(spider.getCourseInfo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String i : courseCode) {
            SelectCourse temp = new SelectCourse();
            temp.setStudentId(userId);
            temp.setCourseCode(i);
            selectCourseMapper.insertSelective(temp);
            //查找官方群组
            GroupExample example = new GroupExample();
            example.or().andCourseCodeEqualTo(i);
            List<Group> tmp = groupMapper.selectByExample(example);
            //加入官方群组
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(userId);
            userGroup.setGroupId(tmp.get(0).getGroupId());
            userGroup.setIsAdministrator(false);
            userGroupMapper.insertSelective(userGroup);
        }
        return "success";
    }

    private List<String> importCourse(List<String> courseInfo) throws InterruptedException {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int groupNum = 0;
        while (i < courseInfo.size()) {
            String courseCode = courseInfo.get(i++);
            String courseName = courseInfo.get(i++);
            String area = courseInfo.get(i++);
            String classInfo = courseInfo.get(i++);
            //检查数据库中是否存在该课程
            CourseExample example = new CourseExample();
            example.or().andCourseCodeEqualTo(courseCode);
            List<Course> temp = courseMapper.selectByExample(example);
            if (temp.size() != 0) {
                ans.add(courseCode);
                continue;
            }
            //数据库中不存在该课程,进行加工处理
            String classInfoA = AnalyzeCourseInfo.classTimeAndLocationAnalyze(classInfo, area);
            if (classInfoA == null) continue;
            else {
                Course course = new Course();
                course.setCourseCode(courseCode);
                course.setCourseName(AnalyzeCourseInfo.courseNameAnalyze(courseName));
                course.setTeacherName(AnalyzeCourseInfo.teacherNameAnalyze(classInfo));
                course.setClassInfo(classInfoA);
                courseMapper.insertSelective(course);
                //创建官方群组
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String adminId = AdminIdCreate.create(groupNum++);
                String groupId = "O" + dtf.format(LocalDateTime.now()) + adminId;
                Group group = new Group();
                group.setGroupId(groupId);
                group.setGroupName(courseName);
                group.setCourseCode(courseCode);
                group.setGroupOwnerId(adminId);
                group.setGroupOwnerName("管理员");
                groupMapper.insertSelective(group);
                ans.add(courseCode);
            }
        }
        return ans;
    }

    public List<Course> getCourseTable(String userId) {
        List<Course> ans = new ArrayList<>();
        SelectCourseExample example = new SelectCourseExample();
        example.or().andStudentIdEqualTo(userId);
        List<SelectCourse> temp = selectCourseMapper.selectByExample(example);
        for (SelectCourse i : temp) {
            String courseCode = i.getCourseCode();
            CourseExample example1 = new CourseExample();
            example.or().andCourseCodeEqualTo(courseCode);
            ans.addAll(courseMapper.selectByExample(example1));
        }
        return ans;
    }

}
