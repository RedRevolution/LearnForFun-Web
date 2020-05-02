package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.KnowledgeShare;
import com.buaa.learnforfun.entity.KnowledgeShareExample;
import java.util.List;

public interface KnowledgeShareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KnowledgeShare record);

    int insertSelective(KnowledgeShare record);

    List<KnowledgeShare> selectByExample(KnowledgeShareExample example);

    KnowledgeShare selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeShare record);

    int updateByPrimaryKey(KnowledgeShare record);
}