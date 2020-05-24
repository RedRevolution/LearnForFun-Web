package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.ChatbotMapper;
import com.buaa.learnforfun.entity.*;
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

    public List<Chatbot> find(Chatbot template) {
        ChatbotExample example = new ChatbotExample();
        if (template.getAsk() != null) {
            example.or().andAskEqualTo(template.getAsk());
        }
        return chatbotMapper.selectByExample(example);
    }

    public List<Chatbot> find() {
        ChatbotExample example = new ChatbotExample();
        example.or().andIdIsNotNull();
        return chatbotMapper.selectByExample(example);
    }

    public void delete(Chatbot chatbot) {
        if (chatbot.getId() != null) {
            chatbotMapper.deleteByPrimaryKey(chatbot.getId());
        } else {
            List<Chatbot> temp = find(chatbot);
            for (Chatbot i : temp) {
                delete(i);
            }
        }
    }

}
