package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserMapper;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserExample;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperService {
    @Autowired
    UserMapper userMapper;

    public void add(User user) {
        userMapper.insertSelective(user);
    }

    public List<User> find(User template) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (template.getUserId() != null) {
            criteria.andUserIdEqualTo(template.getUserId());
        }
        if (template.getUserName() != null) {
            criteria.andUserNameEqualTo(template.getUserName());
        }
        if (template.getOpenId() != null) {
            criteria.andOpenIdEqualTo(template.getOpenId());
        }
        return userMapper.selectByExample(example);
    }

}
