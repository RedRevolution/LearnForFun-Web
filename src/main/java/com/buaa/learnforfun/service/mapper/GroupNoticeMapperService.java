package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupNoticeMapper;
import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.entity.GroupNoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GroupNoticeMapperService {
    @Autowired
    GroupNoticeMapper groupNoticeMapper;

    public void add(GroupNotice groupNotice) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        groupNotice.setCreateBy(dtf.format(LocalDateTime.now()));
        groupNoticeMapper.insertSelective(groupNotice);
    }

    public List<GroupNotice> find(GroupNotice template) {
        GroupNoticeExample example = new GroupNoticeExample();
        GroupNoticeExample.Criteria criteria = example.createCriteria();
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        groupNotice.setCreateBy(dtf.format(LocalDateTime.now()));
        groupNoticeMapper.updateByPrimaryKeySelective(groupNotice);
    }

}
