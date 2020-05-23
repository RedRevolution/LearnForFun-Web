package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.GroupMessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        GroupMessageExample.Criteria criteria = example.createCriteria();
        if (template.getGroupId() != null) {
            criteria.andGroupIdEqualTo(template.getGroupId());
        }
        if (template.getUserId() != null) {
            criteria.andUserIdEqualTo(template.getUserId());
        }
        if (template.getUserName() != null) {
            criteria.andUserNameEqualTo(template.getUserName());
        }
        if (template.getContent() != null) {
            criteria.andContentEqualTo(template.getContent());
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
        example.setOrderByClause("id desc limit " + count);
        List<GroupMessage> temp = groupMessageMapper.selectByExample(example);
        return temp;
    }

    public List<GroupMessage> find(String groupId, long messageId, int count) {
        GroupMessageExample example = new GroupMessageExample();
        example.or().andGroupIdEqualTo(groupId).andIdLessThan(messageId);
        example.setOrderByClause("id desc limit " + count);
        List<GroupMessage> temp = groupMessageMapper.selectByExample(example);
        return temp;
    }

}
