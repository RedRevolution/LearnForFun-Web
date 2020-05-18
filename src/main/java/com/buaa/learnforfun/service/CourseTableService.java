package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.CourseExample;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.SelectCourseExample;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.service.mapper.CourseMapperService;
import com.buaa.learnforfun.service.mapper.GroupMapperService;
import com.buaa.learnforfun.service.mapper.SelectCourseMapperService;
import com.buaa.learnforfun.service.mapper.UserGroupMapperService;
import com.buaa.learnforfun.util.AdminIdCreate;
import com.buaa.learnforfun.util.AnalyzeCourseInfo;
import com.buaa.learnforfun.util.Spider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseTableService {
    CourseMapperService courseMapperService;
    GroupMapperService groupMapperService;
    SelectCourseMapperService selectCourseMapperService;
    UserGroupMapperService userGroupMapperService;

    public String importCourseTable(String userId, String usr, String pwd) {
        //教务爬虫
        Spider spider = new Spider(usr, pwd);
        if (spider.run().equals("failure")) return "failure";
        //导入数据库
        List<String> courseInfo = spider.getCourseInfo();
        int i = 0;
        int groupNo = 0;
        while (i < courseInfo.size()) {
            String courseCode = courseInfo.get(i++);
            String courseName = AnalyzeCourseInfo.courseNameAnalyze(courseInfo.get(i++));
            String area = courseInfo.get(i++);
            String classInfo = courseInfo.get(i++);
            String teacherName = AnalyzeCourseInfo.teacherNameAnalyze(classInfo);
            String formatClassInfo = AnalyzeCourseInfo.classTimeAndLocationAnalyze(classInfo, area);
            //不排课的课程无需处理
            if (formatClassInfo == null) continue;
            //封装实体类
            Course course = new Course();
            course.setCourseCode(courseCode);
            course.setCourseName(courseName);
            course.setTeacherName(teacherName);
            course.setClassInfo(formatClassInfo);
            List<Course> temp = courseMapperService.find(course);
            //数据库中不存在该课程
            if (temp.size() == 0) {
                //创建课程记录
                courseMapperService.add(course);
                //创建官方群组
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String adminId = AdminIdCreate.create(groupNo++);
                String groupId = "O" + dtf.format(LocalDateTime.now()) + adminId;
                Group group = new Group();
                group.setGroupId(groupId);
                group.setGroupName(courseName + "(" + teacherName + ")");
                group.setCourseCode(courseCode);
                group.setGroupOwnerId(adminId);
                group.setGroupOwnerName("趣学管理员");
                groupMapperService.add(group);
            }
            //学生选课
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStudentId(userId);
            selectCourse.setCourseCode(courseCode);
            selectCourse.setTeacherName(teacherName);
            selectCourseMapperService.add(selectCourse);
            //查找官方群组
            Group group = new Group();
            group.setGroupName(courseName + "(" + teacherName + ")");
            group.setCourseCode(courseCode);
            Group tmp = groupMapperService.findByCourse(group);
            //加入官方群组
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(userId);
            userGroup.setGroupId(tmp.getGroupId());
            userGroup.setIsAdministrator(false);
            userGroupMapperService.add(userGroup);
        }
        return "success";
    }

    public List<Course> getCourseTable(String userId) {
        List<Course> ans = new ArrayList<>();
//        SelectCourseExample example = new SelectCourseExample();
//        example.or().andStudentIdEqualTo(userId);
//        List<SelectCourse> temp = selectCourseMapper.selectByExample(example);
//        for (SelectCourse i : temp) {
//            String courseCode = i.getCourseCode();
//            CourseExample example1 = new CourseExample();
//            example1.or().andCourseCodeEqualTo(courseCode);
//            ans.addAll(courseMapper.selectByExample(example1));
//        }
        return ans;
    }

}
