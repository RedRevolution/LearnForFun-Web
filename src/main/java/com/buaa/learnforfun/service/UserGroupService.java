package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
import com.buaa.learnforfun.service.mapper.GroupMapperService;
import com.buaa.learnforfun.service.mapper.UserGroupMapperService;
import com.buaa.learnforfun.service.mapper.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class UserGroupService {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupMapperService groupMapperService;
    @Autowired
    UserGroupMapperService userGroupMapperService;
    @Autowired
    UserMapperService userMapperService;
    @Autowired
    GroupService groupService;

    public Group createGroup(Group group) {
        if (group.getCourseCode().equals("unofficial")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String groupId = "I" + dtf.format(LocalDateTime.now()) + group.getGroupOwnerId();
            group.setGroupId(groupId);
            groupMapperService.add(group);
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(group.getGroupOwnerId());
            userGroup.setUserName(group.getGroupOwnerName());
            userGroup.setGroupId(groupId);
            userGroup.setIsAdministrator(true);
            userGroupMapperService.add(userGroup);
            return group;
        } else {
            //要去数据库中查是否有对应的coursecode
            return null;
        }
    }

    public List<Group> getUserGroupById(String userId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(userId);
        List<UserGroup> userGroups = userGroupMapperService.find(userGroup);
        List<Group> groups = new ArrayList<>();
        for (UserGroup i : userGroups) {
            Group group = new Group();
            group.setGroupId(i.getGroupId());
            groups.addAll(groupMapperService.find(group));
        }
        return groups;
    }

    public String joinGroup(String groupId, String userId) {
        User user = new User();
        user.setUserId(userId);
        String userName = userMapperService.find(user).get(0).getUserName();
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(userId);
        userGroup.setGroupId(groupId);
        userGroup.setUserName(userName);
        userGroup.setIsAdministrator(false);
        return groupService.addGroupMember(userGroup);
    }

    public String exitGroup(String groupId, String userId) {
        return groupService.delelteGroupMember(groupId,userId);
    }


    //群组名、创建者名、课程代码
    public List<Group> searchGroup(String key) {
        HashSet<String> hashSet = new HashSet<>();
        //群组名
        GroupExample example1 = new GroupExample();
        example1.or().andGroupNameLike("%" + key + "%");
        List<Group> temp = groupMapper.selectByExample(example1);
        //创建者名
        GroupExample example2 = new GroupExample();
        example2.or().andGroupOwnerNameLike("%" + key + "%");
        temp.addAll(groupMapper.selectByExample(example2));
        //课程代码
        GroupExample example3 = new GroupExample();
        example3.or().andCourseCodeLike("%" + key + "%");
        temp.addAll(groupMapper.selectByExample(example3));
        List<Group> ans = new ArrayList<>();
        for (Group i : temp) {
            if (!hashSet.contains(i.getGroupId())) {
                hashSet.add(i.getGroupId());
                ans.add(i);
            }
        }
        return ans;
    }
}
