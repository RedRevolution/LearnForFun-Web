package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
import java.util.List;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    List<UserGroup> selectByExample(UserGroupExample example);

    UserGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}