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

    public List<Chatbot> find(Chatbot template) {
        ChatbotExample example = new ChatbotExample();
        if (template.getAsk() != null) {
            example.or().andAskEqualTo(template.getAsk());
        }
        return chatbotMapper.selectByExample(example);
    }

}
