package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperService {
    @Autowired
    UserMapper userMapper;



}
