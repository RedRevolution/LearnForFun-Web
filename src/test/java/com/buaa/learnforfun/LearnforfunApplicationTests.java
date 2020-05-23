//package com.buaa.learnforfun;
//
//import com.buaa.learnforfun.dao.GroupMessageMapper;
//import com.buaa.learnforfun.entity.Course;
//import com.buaa.learnforfun.entity.GroupMessage;
//import com.buaa.learnforfun.service.mapper.CourseMapperService;
//import com.buaa.learnforfun.util.Analyze;
//import com.buaa.learnforfun.util.ChineseUtil;
//import com.buaa.learnforfun.util.DateTimeFormatUtil;
//import com.buaa.learnforfun.util.Spider;
//import com.buaa.learnforfun.util.XiaoAi;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class LearnforfunApplicationTests {
//    @Autowired
//    GroupMessageMapper groupMessageMapper;
//    @Autowired
//    CourseMapperService courseMapperService;
//
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void userServiceTest() {
//        GroupMessage groupMessage = new GroupMessage();
//        groupMessage.setGroupId("123456");
//        groupMessage.setUserId("123456");
//        groupMessage.setUserName("123456");
//        groupMessage.setContent("123456");
//        System.out.println("before\n\n\n\n\n\n");
//        groupMessageMapper.insertSelective(groupMessage);
//        System.out.println("after\n\n\n\n\n\n");
//    }
//
//    @Test
//    void DateTimeFormatUtil() {
//        System.out.println(DateTimeFormatUtil.getCurTime());
//    }
//
//    @Test
//    void SpriderTest() throws InterruptedException {
//        Spider spider = new Spider("cth030811", "cth5201314a");
//        spider.run();
//    }
//
//    @Test
//    void courseMapperTest() {
//        Course course = new Course();
//        course.setCourseCode("B2F080110");
//        course.setTeacherName("单 伟,李亚帅");
//        System.out.println(course.getId());
//        System.out.println(course.getClassInfo());
//        System.out.println(course.getCourseCode());
////        System.out.println(courseMapperService.findSysMessage(course).size());
//    }
//
//    @Test
//    void chineseUtilTest() {
//        ChineseUtil chineseUtil = new ChineseUtil();
//        System.out.println(chineseUtil.getAllFirstLetter("欧阳元新，王德庆"));
//    }
//
//    @Test
//    void XiaoAiUtilTest(){
//       System.out.println(XiaoAi.filter("重庆今天22℃~29℃ 小雨 0-3级 \\u003c5.4m/s\\r\\n天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"));
//    }
//
//    @Test
//    void AnalyzeCourseInfoTest() {
////        String ans = Analyze.courseName("体育（6）【游泳1】");
////        String ans1 = Analyze.courseName("计算机网络(全汉语)");
////        System.out.println(ans);
////        System.out.println(ans1);
////        String ans = Analyze.teacherName(" [主任务]单 伟,李亚帅dadadadadadaddadadadadadada◇[1-5周]星期二第3,4节◇F227,[6-8周]星期二第3,4节◇(一)301,[9-16周]星期二第3,节◇(一)301◇选课要求:◇◇");
////        String ans1 = Analyze.teacherName("罗洪斌◇[1-9周]星期二第1,2节◇(一)301,[1-9周]星期四第3,4节◇(一)301");
////        System.out.println(ans);
////        String ans = Analyze.classTimeAndLocation(" [主任务]单 伟,李亚帅◇[1-5周]星期二第3,4节◇F227,[6-8周]星期二第3,4节◇(一)301,[9-16周]星期二第3,4节◇(一)301◇选课要求:◇◇","学院路校区");
////        String ans = Analyze.classTimeAndLocation(" [主任务]姚建军◇[1-17周]星期一第6节◇","学院路校区");
////        String ans = Analyze.classTimeAndLocation(" 王嘉凯◇[1-16周]◇","学院路校区");
////        String ans = Analyze.classTimeAndLocation(" 李 波◇[1-9周]星期四第1,2节◇主M302","学院路校区");
////        String ans = Analyze.classTimeAndLocation(" 罗洪斌◇[1-9周]星期二第1,2节◇(一)301,[1-9周]星期四第3,4节◇(一)301","学院路校区");
//        String ans = Analyze.classTimeAndLocation(" 杨建磊◇[1-16周]星期一第3,4节◇主319,[11周]星期日第3,4节◇主319,[9周]星期日第3,4节◇主319", "学院路校区");
//        System.out.println(ans);
//    }
//
//}
//
////    @Autowired
////    private UserService userService;
////    @Autowired
////    private GroupMessageService groupMessageService;
////    @Test
////    void userServiceTest() {
////        User user = new User();
////        user.setOpenId("cth201401");
////        user.setUserId("17373291");
////        user.setUserName("程添红");
//
//
////        String code = "0231pXj010MzqU1jMkj019cOj011pXj2";
////        String openId = WeChatOpenId.getOpenId("wxbe3bc73b7a961e66", code, "b3351f7d2fe64e7ea3a8392bbeeb2fea");
////        User tmp = userService.getUserByWechatId("cth201401");
////        if(tmp == null)System.out.println("\nyes\n");
////        System.out.print("\n\n\n\n"+openId+"\n\n\n\n");