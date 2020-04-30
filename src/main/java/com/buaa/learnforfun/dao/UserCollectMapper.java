package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserCollectExample;
import java.util.List;

public interface UserCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollect record);

    int insertSelective(UserCollect record);

    List<UserCollect> selectByExample(UserCollectExample example);

    UserCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);
}