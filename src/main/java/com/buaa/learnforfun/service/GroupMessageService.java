package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.service.mapper.GroupMessageMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMessageService {
    @Autowired
    GroupMessageMapperService groupMessageMapperService;

    public void addGroupMessage(GroupMessage groupMessage) {
        groupMessageMapperService.add(groupMessage);
    }


}
