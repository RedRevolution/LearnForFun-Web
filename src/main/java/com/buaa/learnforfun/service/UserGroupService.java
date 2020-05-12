package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
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
    UserGroupMapper userGroupMapper;

    public Group createGroup(Group group) {
        if (group.getCourseCode().equals("unofficial")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String groupId = "I" + dtf.format(LocalDateTime.now()) + group.getGroupOwnerId();
            group.setGroupId(groupId);
            groupMapper.insertSelective(group);
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(group.getGroupOwnerId());
            userGroup.setGroupId(groupId);
            userGroup.setIsAdministrator(true);
            userGroupMapper.insertSelective(userGroup);
            return group;
        } else {
            //要去数据库中查是否有对应的coursecode
            return null;
        }
    }

    public List<Group> getUserGroupById(String userId) {
        UserGroupExample example = new UserGroupExample();
        example.or().andUserIdEqualTo(userId);
        List<UserGroup> userGroups = userGroupMapper.selectByExample(example);
        List<Group> groups = new ArrayList<>();
        for (UserGroup i : userGroups) {
            GroupExample groupExample = new GroupExample();
            groupExample.or().andGroupIdEqualTo(i.getGroupId());
            groups.addAll(groupMapper.selectByExample(groupExample));
        }
        return groups;
    }

    public String joinGroup(String groupId, String userId) {
        UserGroupExample example = new UserGroupExample();
        example.or().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
        List<UserGroup> temp = userGroupMapper.selectByExample(example);
        if (temp.size() == 0) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(userId);
            userGroup.setGroupId(groupId);
            userGroup.setIsAdministrator(false);
            userGroupMapper.insertSelective(userGroup);
            return "success";
        } else return "exist";
    }

    public String exitGroup(String groupId, String userId) {
        UserGroupExample example = new UserGroupExample();
        example.or().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
        List<UserGroup> temp = userGroupMapper.selectByExample(example);
        if (temp.size() != 0) {
            userGroupMapper.deleteByPrimaryKey(temp.get(0).getId());
            return "success";
        } else return "quit";
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
