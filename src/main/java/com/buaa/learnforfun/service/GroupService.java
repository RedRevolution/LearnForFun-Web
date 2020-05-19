package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.service.mapper.GroupMapperService;
import com.buaa.learnforfun.service.mapper.GroupMessageMapperService;
import com.buaa.learnforfun.service.mapper.ShareMapperService;
import com.buaa.learnforfun.service.mapper.UserGroupMapperService;
import com.buaa.learnforfun.service.mapper.UserMapperService;
import org.omg.CORBA.portable.ValueOutputStream;
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

    //管理台查看所有群组列表
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

    public String modifyGroupInfo(Group group) {
        groupMapperService.update(group);
        return "success";
    }

    //查看群成员列表
    public List<UserGroup> getGroupMember(String groupId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(groupId);
        return userGroupMapperService.find(userGroup);
    }

    //管理台用于设置或修改管理权限
    public void modifyPri(String groupId, String userId, boolean isAdmin) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(groupId);
        userGroup.setUserId(userId);
        List<UserGroup> temp = userGroupMapperService.find(userGroup);
        UserGroup ug = temp.get(0);
        ug.setIsAdministrator(isAdmin);
        userGroupMapperService.update(ug);
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

    public String addGroupMember(UserGroup userGroup) {
        List<UserGroup> temp = userGroupMapperService.find(userGroup);
        if (temp.size() != 0) return "exist";
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
