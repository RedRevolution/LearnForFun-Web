package com.buaa.learnforfun;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.service.GroupMessageService;
import com.buaa.learnforfun.service.UserService;
import com.buaa.learnforfun.util.DateTimeFormatUtil;
import com.buaa.learnforfun.util.WeChatOpenId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearnforfunApplicationTests {
    @Autowired
    GroupMessageMapper groupMessageMapper;

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