package com.buaa.learnforfun.controller.Fore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

//    @RequestMapping("/group")
//    public String groupPage() {
//        return "page/group";
//    }
//
//    @RequestMapping("/addGroup")
//    public String addGroup() {
//        return "page/addGroup";
//    }
//
//    @RequestMapping("/addGroupUser")
//    public String addGroupUser() {
//        return "page/addGroupUser";
//    }

    @RequestMapping("/home")
    public String home(){
        return "page/home";
    }

    @RequestMapping("/group")
    public String group() {
        return "page/group/list";
    }

    @RequestMapping("/groupAdd")
    public String groupAdd() {
        return "page/group/add";
    }

    @RequestMapping("/groupUserAdd")
    public String groupUserAdd() {
        return "page/group/userAdd";
    }

    @RequestMapping("/message")
    public String message() {
        return "page/message/list";
    }

    @RequestMapping("/chatbot")
    public String chatbot() {
        return "page/chatbot/list";
    }

    @RequestMapping("/chatbotAdd")
    public String chatbotAdd() {
        return "page/chatbot/add";
    }

}
