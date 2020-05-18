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
                groupMessageMapper.deleteByPrimaryKey(i.getId());
            }
        }
    }

}
