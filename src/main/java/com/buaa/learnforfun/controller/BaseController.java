package com.buaa.learnforfun.controller;

import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.service.CourseTableService;
import com.buaa.learnforfun.service.GroupMessageService;
import com.buaa.learnforfun.service.GroupNoticeService;
import com.buaa.learnforfun.service.GroupService;
import com.buaa.learnforfun.service.ShareService;
import com.buaa.learnforfun.service.SysService;
import com.buaa.learnforfun.service.TimetableService;
import com.buaa.learnforfun.service.UserGroupService;
import com.buaa.learnforfun.service.UserService;
import com.buaa.learnforfun.service.XiaoQuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BaseController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserGroupService userGroupService;

    @Autowired
    public TimetableService timetableService;

    @Autowired
    public GroupService groupService;

    @Autowired
    public GroupMessageService groupMessageService;

    @Autowired
    public ShareService shareService;

    @Autowired
    public CourseTableService courseTableService;

    @Autowired
    public XiaoQuService xiaoQuService;

    @Autowired
    public GroupNoticeService groupNoticeService;

    @Autowired
    public SysService sysService;
}
