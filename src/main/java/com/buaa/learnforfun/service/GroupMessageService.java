package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.service.mapper.GroupMessageMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GroupMessageService {
    @Autowired
    GroupMessageMapperService groupMessageMapperService;

    public void addGroupMessage(GroupMessage groupMessage) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        groupMessage.setCreateBy(dtf.format(LocalDateTime.now()));
        groupMessageMapperService.add(groupMessage);
    }

    public List<GroupMessage> getGroupMessageRecord(String groupId, int count) {
        return groupMessageMapperService.find(groupId, count);
    }

    public List<GroupMessage> getRecordByMessageId(String groupId, long messageId, int count) {
        return groupMessageMapperService.find(groupId, messageId, count);
    }

}
