package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.ResourceShare;
import com.buaa.learnforfun.entity.ResourceShareExample;
import java.util.List;

public interface ResourceShareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceShare record);

    int insertSelective(ResourceShare record);

    List<ResourceShare> selectByExample(ResourceShareExample example);

    ResourceShare selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceShare record);

    int updateByPrimaryKey(ResourceShare record);
}