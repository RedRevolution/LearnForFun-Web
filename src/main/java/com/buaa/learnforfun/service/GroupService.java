package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.service.mapper.GroupMapperService;
import com.buaa.learnforfun.service.mapper.GroupMessageMapperService;
import com.buaa.learnforfun.service.mapper.ShareMapperService;
import com.buaa.learnforfun.service.mapper.UserGroupMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupMapperService groupMapperService;
    @Autowired
    UserGroupMapperService userGroupMapperService;
    @Autowired
    GroupMessageMapperService groupMessageMapperService;
    @Autowired
    ShareMapperService shareMapperService;

    public List<Group> getAllGroupInfo() {
        return groupMapperService.findAll();
    }

    public List<String> getMember() {
        return null;
    }

    public Group getGroupInfo(String groupId) {
        Group template = new Group();
        template.setGroupId(groupId);
        return groupMapperService.find(template).get(0);
    }

    public String isAdministrator(String groupId, String userId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(userId);
        userGroup.setGroupId(groupId);
        List<UserGroup> temp = userGroupMapperService.find(userGroup);
        if (temp.size() == 0) return "nongroupmember";
        else if (temp.get(0).getIsAdministrator() == true) return "administrator";
        else return "groupmember";
    }

    public String addGroupMember(String groupId, String userId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(userId);
        userGroup.setGroupId(groupId);
        List<UserGroup> temp = userGroupMapperService.find(userGroup);
        if (temp.size() != 0) return "exist";
        userGroup.setIsAdministrator(false);
        userGroupMapperService.add(userGroup);
        return "success";
    }

    public String delelteGroupMember(String groupId, String userId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(userId);
        userGroup.setGroupId(groupId);
        List<UserGroup> temp = userGroupMapperService.find(userGroup);
        if (temp.size() == 0) return "nonexist";
        else {
            //删除群成员关系记录
            userGroupMapperService.delete(temp.get(0));
            //删除群消息记录
            GroupMessage groupMessage = new GroupMessage();
            groupMessage.setUserId(userId);
            groupMessage.setGroupId(groupId);
            groupMessageMapperService.delete(groupMessage);
            //删除群分享记录(包括分享下的评论记录，以及用户的收藏记录)
            Share share = new Share();
            share.setGroupId(groupId);
            share.setUserId(userId);
            shareMapperService.delete(share);
            return "success";
        }
    }


    public String dismissGroup(String groupId) {
        Group group = new Group();
        group.setGroupId(groupId);
        groupMapperService.delete(group);
        return "success";
    }


}
