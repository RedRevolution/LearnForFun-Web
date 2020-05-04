package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.GroupMessage;

public interface GroupMessageService {
    void addGroupMessage(String groupId, String userId, String userName, String message);
//    void addGroupMessage(GroupMessage groupMessage);
}
