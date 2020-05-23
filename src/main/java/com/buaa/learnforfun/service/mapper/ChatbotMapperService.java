package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.ChatbotMapper;
import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.entity.ChatbotExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatbotMapperService {
    @Autowired
    ChatbotMapper chatbotMapper;

    public void add(Chatbot chatbot) {
        chatbotMapper.insertSelective(chatbot);
    }

    public List<Chatbot> find(String question) {
        ChatbotExample example = new ChatbotExample();
        example.or().andAskLike("%" + question + "%");
        return chatbotMapper.selectByExample(example);
    }

    public List<Chatbot> find() {
        ChatbotExample example = new ChatbotExample();
        example.or().andIdIsNotNull();
        return chatbotMapper.selectByExample(example);
    }

}
