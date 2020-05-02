package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.UserMapper;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByOpenId(String id) {
        UserExample example = new UserExample();
        example.or().andOpenIdEqualTo(id);
        List<User> ans = userMapper.selectByExample(example);
        if (ans.size() == 0) {
            User temp = new User();
            temp.setOpenId(id);
            temp.setUserId("unbound");
            return temp;
        } else return ans.get(0);
    }

    public User bindUserInfo(User user) {
        //查询userId是否重复
        UserExample example = new UserExample();
        example.or().andUserIdEqualTo(user.getUserId());
        List<User> tmp = userMapper.selectByExample(example);
        if (tmp.size() != 0) {  //userId有重复
            User temp = new User();
            temp.setOpenId(user.getOpenId());
            temp.setUserId("duplicate");
            temp.setUserName(user.getUserName());
            return temp;
        } else {
            userMapper.insertSelective(user);
            return user;
        }
    }
}
