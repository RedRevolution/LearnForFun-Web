package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.service.mapper.CourseMapperService;
import com.buaa.learnforfun.service.mapper.GroupMapperService;
import com.buaa.learnforfun.service.mapper.SelectCourseMapperService;
import com.buaa.learnforfun.service.mapper.UserGroupMapperService;
import com.buaa.learnforfun.util.AdminIdCreate;
import com.buaa.learnforfun.util.Analyze;
import com.buaa.learnforfun.util.ChineseUtil;
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
    CourseMapperService courseMapperService;
    @Autowired
    GroupMapperService groupMapperService;
    @Autowired
    SelectCourseMapperService selectCourseMapperService;
    @Autowired
    UserGroupMapperService userGroupMapperService;
    @Autowired
    UserGroupService userGroupService;

    public String importCourseTable(String userId, String usr, String pwd) {
        //教务爬虫
        Spider spider = new Spider(usr, pwd);
        if (spider.run().equals("failure")) return "failure";
        //System.out.println("\n\n\n\n\n\nsuccess\n\n\n\n\n\n\n\n" );
        //导入数据库
        List<String> courseInfo = spider.getCourseInfo();
        int i = 0;
        int groupNo = 0;
        while (i < courseInfo.size()) {
            String courseCode = courseInfo.get(i++);
            String courseName = Analyze.courseName(courseInfo.get(i++));
            String area = courseInfo.get(i++);
            String classInfo = courseInfo.get(i++);
            String teacherName = Analyze.teacherName(classInfo);
            String formatClassInfo = Analyze.classTimeAndLocation(classInfo, area);
            //不排课的课程无需处理
            if (formatClassInfo == null) continue;
            //封装实体类
            Course course = new Course();
            ChineseUtil chineseUtil = new ChineseUtil();
            String courseId = courseCode + chineseUtil.getAllFirstLetter(teacherName);
            course.setCourseId(courseId);
            List<Course> temp = courseMapperService.find(course);
            //数据库中不存在该课程
            if (temp.size() == 0) {
                //创建官方群组
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String adminId = AdminIdCreate.create(groupNo++);
                String groupId = "O" + dtf.format(LocalDateTime.now()) + adminId;
                Group group = new Group();
                group.setGroupId(groupId);
                if (teacherName.length() > 14) {
                    group.setGroupName(courseName + "(" + teacherName.substring(0, 15) + ")");
                } else {
                    group.setGroupName(courseName + "(" + teacherName + ")");
                }
                group.setCourseCode(courseCode);
                group.setGroupOwnerId(adminId);
                group.setGroupOwnerName("趣学管理员");
                groupMapperService.add(group);
                //创建课程记录
                course.setCourseCode(courseCode);
                course.setCourseName(courseName);
                course.setTeacherName(teacherName);
                course.setClassInfo(formatClassInfo);
                course.setGroupId(groupId);
                courseMapperService.add(course);
                //加入官方群组
                userGroupService.joinGroup(groupId, userId);
            } else {
                //加入官方群组
                userGroupService.joinGroup(temp.get(0).getGroupId(), userId);
            }
            //学生选课
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStudentId(userId);
            selectCourse.setCourseId(courseId);
            selectCourseMapperService.add(selectCourse);
        }
        return "success";
    }

    public List<Course> getCourseTable(String userId) {
        List<Course> ans = new ArrayList<>();
        SelectCourse template = new SelectCourse();
        template.setStudentId(userId);
        List<SelectCourse> temp = selectCourseMapperService.find(template);
        for (SelectCourse i : temp) {
            Course courseT = new Course();
            courseT.setCourseId(i.getCourseId());
            ans.addAll(courseMapperService.find(courseT));
        }
        return ans;
    }

}
