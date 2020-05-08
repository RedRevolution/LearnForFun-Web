package com.buaa.learnforfun.controller;

import com.buaa.learnforfun.service.UserGroupService;
import com.buaa.learnforfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BaseController {
    @GetMapping("hello")
    public String hello(){
        return "hello,red!";
    }

    @Autowired
    public UserService userService;

    @Autowired
    public UserGroupService userGroupService;

}
