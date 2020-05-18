package com.buaa.learnforfun;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.service.GroupMessageService;
import com.buaa.learnforfun.service.UserService;
import com.buaa.learnforfun.service.mapper.CourseMapperService;
import com.buaa.learnforfun.util.AnalyzeCourseInfo;
import com.buaa.learnforfun.util.DateTimeFormatUtil;
import com.buaa.learnforfun.util.Spider;
import com.buaa.learnforfun.util.WeChatOpenId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearnforfunApplicationTests {
    @Autowired
    GroupMessageMapper groupMessageMapper;
    @Autowired
    CourseMapperService courseMapperService;


    @Test
    void contextLoads() {
    }

    @Test
    void userServiceTest() {
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId("123456");
        groupMessage.setUserId("123456");
        groupMessage.setUserName("123456");
        groupMessage.setContent("123456");
        System.out.println("before\n\n\n\n\n\n");
        groupMessageMapper.insertSelective(groupMessage);
        System.out.println("after\n\n\n\n\n\n");
    }

    @Test
    void DateTimeFormatUtil() {
        System.out.println(DateTimeFormatUtil.getCurTime());
    }

    @Test
    void SpriderTest() throws InterruptedException {
        Spider spider = new Spider("cth030811", "cth5201314a");
        spider.run();
    }

    @Test
    void courseMapperTest() {
        Course course = new Course();
        course.setCourseCode("B2F080110");
        course.setTeacherName("单 伟,李亚帅");
        System.out.println(courseMapperService.find(course).size());
    }

    @Test
    void AnalyzeCourseInfoTest() {
//        String ans = AnalyzeCourseInfo.courseNameAnalyze("体育（6）【游泳1】");
//        String ans1 = AnalyzeCourseInfo.courseNameAnalyze("计算机网络(全汉语)");
//        System.out.println(ans);
//        System.out.println(ans1);
//        String ans = AnalyzeCourseInfo.teacherNameAnalyze(" [主任务]单 伟,李亚帅dadadadadadaddadadadadadada◇[1-5周]星期二第3,4节◇F227,[6-8周]星期二第3,4节◇(一)301,[9-16周]星期二第3,节◇(一)301◇选课要求:◇◇");
//        String ans1 = AnalyzeCourseInfo.teacherNameAnalyze("罗洪斌◇[1-9周]星期二第1,2节◇(一)301,[1-9周]星期四第3,4节◇(一)301");
//        System.out.println(ans);
//        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" [主任务]单 伟,李亚帅◇[1-5周]星期二第3,4节◇F227,[6-8周]星期二第3,4节◇(一)301,[9-16周]星期二第3,4节◇(一)301◇选课要求:◇◇","学院路校区");
//        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" [主任务]姚建军◇[1-17周]星期一第6节◇","学院路校区");
//        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" 王嘉凯◇[1-16周]◇","学院路校区");
//        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" 李 波◇[1-9周]星期四第1,2节◇主M302","学院路校区");
//        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" 罗洪斌◇[1-9周]星期二第1,2节◇(一)301,[1-9周]星期四第3,4节◇(一)301","学院路校区");
        String ans = AnalyzeCourseInfo.classTimeAndLocationAnalyze(" 杨建磊◇[1-16周]星期一第3,4节◇主319,[11周]星期日第3,4节◇主319,[9周]星期日第3,4节◇主319", "学院路校区");
        System.out.println(ans);
    }

}

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private GroupMessageService groupMessageService;
//    @Test
//    void userServiceTest() {
//        User user = new User();
//        user.setOpenId("cth201401");
//        user.setUserId("17373291");
//        user.setUserName("程添红");


//        String code = "0231pXj010MzqU1jMkj019cOj011pXj2";
//        String openId = WeChatOpenId.getOpenId("wxbe3bc73b7a961e66", code, "b3351f7d2fe64e7ea3a8392bbeeb2fea");
//        User tmp = userService.getUserByWechatId("cth201401");
//        if(tmp == null)System.out.println("\nyes\n");
//        System.out.print("\n\n\n\n"+openId+"\n\n\n\n");