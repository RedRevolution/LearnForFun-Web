package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}