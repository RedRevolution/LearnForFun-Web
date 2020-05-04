package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMessageServiceImpl implements GroupMessageService {
    @Autowired
    GroupMessageMapper groupMessageMapper;

    @Override
    public void addGroupMessage(String groupId,String userId,String userName,String message) {
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId(groupId);
        groupMessage.setUserId(userId);
        groupMessage.setUserName(userName);
        groupMessage.setContent(message);
        System.out.println("before\n\n\n\n\n\n");
        groupMessageMapper.insertSelective(groupMessage);
        System.out.println("\n\n\n\n\n\n");
    }
}
