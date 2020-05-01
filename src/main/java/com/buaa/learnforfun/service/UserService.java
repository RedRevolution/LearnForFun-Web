package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.User;

public interface UserService {
    User getUserByWechatId(String id);
    User register(User user);

}
