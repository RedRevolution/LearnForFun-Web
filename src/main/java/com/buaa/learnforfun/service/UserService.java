package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.UserMapper;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserExample;
import com.buaa.learnforfun.util.WeChatOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByCode(String code) {
        String openId = WeChatOpenId.getOpenId("wxbe3bc73b7a961e66", code, "rjgc2020");
        UserExample example = new UserExample();
        example.or().andOpenIdEqualTo(openId);
        List<User> ans = userMapper.selectByExample(example);
        if (ans.size() == 0) {
            User temp = new User();
            temp.setOpenId(openId);
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
            return null;
        } else {
            userMapper.insertSelective(user);
            return user;
        }
    }
}
