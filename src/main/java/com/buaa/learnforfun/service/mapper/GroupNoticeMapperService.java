package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupNoticeMapper;
import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.entity.GroupNoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupNoticeMapperService {
    @Autowired
    GroupNoticeMapper groupNoticeMapper;

    public void add(GroupNotice groupNotice) {
        groupNoticeMapper.insertSelective(groupNotice);
    }

    public List<GroupNotice> find(GroupNotice template) {
        GroupNoticeExample example = new GroupNoticeExample();
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
        return groupNoticeMapper.selectByExample(example);
    }

    public void delete(GroupNotice groupNotice) {
        if (groupNotice.getId() != null) {
            groupNoticeMapper.deleteByPrimaryKey(groupNotice.getId());
        } else {
            List<GroupNotice> temp = find(groupNotice);
            for (GroupNotice i : temp) {
                delete(i);
            }
        }
    }

    public void update(GroupNotice groupNotice) {
        groupNoticeMapper.updateByPrimaryKeySelective(groupNotice);
    }

}
