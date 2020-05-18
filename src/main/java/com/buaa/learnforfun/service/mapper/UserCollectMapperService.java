package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserCollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectMapperService {
    @Autowired
    UserCollectMapper userCollectMapper;

}
