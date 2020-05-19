package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMapperService {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupMessageMapperService groupMessageMapperService;
    @Autowired
    GroupNoticeMapperService groupNoticeMapperService;
    @Autowired
    ShareMapperService shareMapperService;
    @Autowired
    UserGroupMapperService userGroupMapperService;

    public void add(Group group) {
        groupMapper.insertSelective(group);
    }

    public List<Group> find(Group template) {
        GroupExample example = new GroupExample();
        if (template.getGroupId() != null) {
            example.or().andGroupIdEqualTo(template.getGroupId());
        }
        if (template.getGroupName() != null) {
            example.or().andGroupNameEqualTo(template.getGroupName());
        }
        if (template.getGroupOwnerId() != null) {
            example.or().andGroupOwnerIdEqualTo(template.getGroupOwnerId());
        }
        if (template.getGroupOwnerName() != null) {
            example.or().andGroupOwnerNameEqualTo(template.getGroupOwnerName());
        }
        if (template.getGroupIntrod() != null) {
            example.or().andGroupIntrodEqualTo(template.getGroupIntrod());
        }
        if (template.getCourseCode() != null) {
            example.or().andCourseCodeEqualTo(template.getCourseCode());
        }
        return groupMapper.selectByExample(example);
    }

    public List<Group> findAll() {
        GroupExample example = new GroupExample();
        example.or().andIdIsNotNull();
        return groupMapper.selectByExample(example);
    }

    public void delete(Group group) {
        if (group.getId() != null) {
            //官方群组不能被删除
            if (group.getGroupId().charAt(0) == 'O') return;
            //从群组列表中删除
            groupMapper.deleteByPrimaryKey(group.getId());
            //删除群消息记录
            GroupMessage groupMessage = new GroupMessage();
            groupMessage.setGroupId(group.getGroupId());
            groupMessageMapperService.delete(groupMessage);
            //删除群公告记录
            GroupNotice groupNotice = new GroupNotice();
            groupNotice.setGroupId(group.getGroupId());
            groupNoticeMapperService.delete(groupNotice);
            //删除群分享记录
            Share share = new Share();
            share.setGroupId(group.getGroupId());
            shareMapperService.delete(share);
            //删除用户群列表记录
            UserGroup userGroup = new UserGroup();
            userGroup.setGroupId(group.getGroupId());
            userGroupMapperService.delete(userGroup);
        } else {
            List<Group> temp = find(group);
            for (Group i : temp) {
                delete(i);
            }
        }
    }

    public void update(Group group) {
        groupMapper.updateByPrimaryKeySelective(group);
    }

}
