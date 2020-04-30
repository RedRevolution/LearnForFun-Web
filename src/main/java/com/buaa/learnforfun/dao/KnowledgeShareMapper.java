package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.KnowledgeShare;
import com.buaa.learnforfun.entity.KnowledgeShareExample;
import java.util.List;

public interface KnowledgeShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgeShare record);

    int insertSelective(KnowledgeShare record);

    List<KnowledgeShare> selectByExample(KnowledgeShareExample example);

    KnowledgeShare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgeShare record);

    int updateByPrimaryKey(KnowledgeShare record);
}