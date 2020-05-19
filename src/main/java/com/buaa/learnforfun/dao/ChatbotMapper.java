package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.entity.ChatbotExample;
import java.util.List;

public interface ChatbotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Chatbot record);

    int insertSelective(Chatbot record);

    List<Chatbot> selectByExample(ChatbotExample example);

    Chatbot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chatbot record);

    int updateByPrimaryKey(Chatbot record);
}