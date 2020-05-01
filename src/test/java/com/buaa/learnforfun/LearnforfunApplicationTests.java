package com.buaa.learnforfun;

import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.service.UserService;
import com.buaa.learnforfun.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnforfunApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void userServiceTest(){
        User user = new User();
        user.setWechatAccountId("cth201401");
        user.setUserId(17373291);
        user.setUserName("程添红");

//        User tmp = userService.getUserByWechatId("cth201401");
//        if(tmp == null)System.out.println("\nyes\n");
        userService.register(user);
    }

}
