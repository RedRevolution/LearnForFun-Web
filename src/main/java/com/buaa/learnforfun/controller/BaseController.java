package com.buaa.learnforfun.controller;

import com.buaa.learnforfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    UserService userService;
}
