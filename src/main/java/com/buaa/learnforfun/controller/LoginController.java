package com.buaa.learnforfun.controller;

import com.alibaba.druid.util.StringUtils;
import com.buaa.learnforfun.dto.JsonData;
import com.buaa.learnforfun.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }


    // 发送post请求，代替了RequestMapping（value="/user/login", method="post"）
    @PostMapping(value = "/login")
    @ResponseBody
    // 对登录请求判断request的参数值，并存放在map中
    public JsonData login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        // 我们判断，如果登录名不是空，并且，密码是 123456 就登录成功（暂不涉及数据库）
        if (Objects.equals(username,"admin") && "123456".equals(password)) {
            // 登录成功，就跳转到下一个页面
            User user = new User();
            user.setUserName(username);
            request.getSession().setAttribute("loginUser",user);
            return JsonData.success();
        } else {
            // 登录失败，刷新本登录页
            return JsonData.fail("用户名密码错误");
        }
    }

//    /**
//     * 登录
//     *
//     * @param user
//     * @param session
//     * @return
//     */
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(User user, HttpSession session) {
//
//        if (user != null) {
//            User loginUser = userService.login(user);
//            if (loginUser != null) {
//                session.setAttribute("loginUser", loginUser);
//                return loginUser.getId()+"";
//            }
//        }
//        return "error";
//    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

}
