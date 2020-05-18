package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMapperService {
    @Autowired
    UserGroupMapper userGroupMapper;

    public void add(UserGroup userGroup) {
        userGroupMapper.insertSelective(userGroup);
    }

    public List<UserGroup> find(UserGroup template) {
        UserGroupExample example = new UserGroupExample();
        if (template.getUserId() != null) {
            example.or().andUserIdEqualTo(template.getUserId());
        }
        if (template.getGroupId() != null) {
            example.or().andGroupIdEqualTo(template.getGroupId());
        }
        return userGroupMapper.selectByExample(example);
    }

    public void delete(UserGroup template) {
        if (template.getId() != null) {
            userGroupMapper.deleteByPrimaryKey(template.getId());
        } else {
            List<UserGroup> temp = find(template);
            for (UserGroup i : temp) {
                userGroupMapper.deleteByPrimaryKey(i.getId());
            }
        }
    }

}
