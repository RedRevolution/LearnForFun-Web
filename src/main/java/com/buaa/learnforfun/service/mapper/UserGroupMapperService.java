package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupMapperService {
    @Autowired
    UserGroupMapper userGroupMapper;

    public void add(UserGroup userGroup) {
        userGroupMapper.insertSelective(userGroup);
    }

}
