package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.GroupMessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupMessageMapperService {
    @Autowired
    GroupMessageMapper groupMessageMapper;

    public void add(GroupMessage groupMessage) {
        groupMessageMapper.insertSelective(groupMessage);
    }

    public List<GroupMessage> find(GroupMessage template) {
        GroupMessageExample example = new GroupMessageExample();
        if (template.getGroupId() != null) {
            example.or().andGroupIdEqualTo(template.getGroupId());
        }
        if (template.getUserId() != null) {
            example.or().andUserIdEqualTo(template.getUserId());
        }
        if (template.getUserName() != null) {
            example.or().andUserNameEqualTo(template.getUserName());
        }
        if (template.getContent() != null) {
            example.or().andContentEqualTo(template.getContent());
        }
        return groupMessageMapper.selectByExample(example);
    }

    public void delete(GroupMessage template) {
        if (template.getId() != null) {
            groupMessageMapper.deleteByPrimaryKey(template.getId());
        } else {
            List<GroupMessage> temp = find(template);
            for (GroupMessage i : temp) {
                delete(i);
            }
        }
    }

    public List<GroupMessage> find(String groupId, int count) {
        GroupMessageExample example = new GroupMessageExample();
        example.or().andGroupIdEqualTo(groupId);
        example.setOrderByClause("id ASC");
        List<GroupMessage> temp = groupMessageMapper.selectByExample(example);
        if (temp.size() > count) {
            List<GroupMessage> groupMessages = new ArrayList<>();
            for (int i = 0; i < count; i++) groupMessages.add(temp.get(i));
            return groupMessages;
        } else {
            return temp;
        }
    }

    public List<GroupMessage> find(String groupId, long messageId, int count) {
        GroupMessageExample example = new GroupMessageExample();
        example.or().andGroupIdEqualTo(groupId);
        example.or().andIdLessThan(messageId);
        example.setOrderByClause("id ASC");
        List<GroupMessage> temp = groupMessageMapper.selectByExample(example);
        if (temp.size() > count) {
            List<GroupMessage> groupMessages = new ArrayList<>();
            for (int i = 0; i < count; i++) groupMessages.add(temp.get(i));
            return groupMessages;
        } else {
            return temp;
        }
    }

}
