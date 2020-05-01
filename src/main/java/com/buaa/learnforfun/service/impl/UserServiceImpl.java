package com.buaa.learnforfun.service.impl;

import com.buaa.learnforfun.dao.UserMapper;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserExample;
import com.buaa.learnforfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByWechatId(String id) {
        UserExample example = new UserExample();
        example.or().andWechatAccountIdEqualTo(id);
        List<User> ans = userMapper.selectByExample(example);
        if(ans.size() == 0)return null;
        else return ans.get(0);
    }

    @Override
    public User register(User user) {
        userMapper.insertSelective(user);
        return user;
    }
}
