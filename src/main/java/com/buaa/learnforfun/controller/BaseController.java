package com.buaa.learnforfun.controller;

import com.buaa.learnforfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {
    @Autowired
    UserService userService;

}
