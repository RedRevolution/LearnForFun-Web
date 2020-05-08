package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

}
