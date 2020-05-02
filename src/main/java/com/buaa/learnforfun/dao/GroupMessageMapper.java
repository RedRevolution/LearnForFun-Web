package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.entity.GroupMessageExample;
import java.util.List;

public interface GroupMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupMessage record);

    int insertSelective(GroupMessage record);

    List<GroupMessage> selectByExample(GroupMessageExample example);

    GroupMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupMessage record);

    int updateByPrimaryKey(GroupMessage record);
}