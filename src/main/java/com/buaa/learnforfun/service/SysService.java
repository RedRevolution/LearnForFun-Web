package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.service.mapper.ChatbotMapperService;
import com.buaa.learnforfun.service.mapper.SysMessageMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysService {
    @Autowired
    SysMessageMapperService sysMessageMapperService;
    @Autowired
    ChatbotMapperService chatbotMapperService;

    public String userToSys(String userId, String content) {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setUserId(userId);
        sysMessage.setContent(content);
        sysMessageMapperService.add(sysMessage);
        return "success";
    }

    public String getSysMessage() {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setUserId("00000000");
        List<SysMessage> temp = sysMessageMapperService.find(sysMessage);
        if (temp.size() == 0) {
            return "";
        } else {
            return temp.get(temp.size() - 1).getContent();
        }
    }

    //后台获取用户的反馈
    public List<SysMessage> getAllUsrMessage() {
        return sysMessageMapperService.find();
    }

    //后台发布系统消息
    public void releaseMessage(String content) {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setUserId("00000000");
        sysMessage.setContent(content);
        sysMessageMapperService.add(sysMessage);
    }

    //后台为聊天机器人预设字段
    public void setChatbot(String ask, String answer) {
        Chatbot chatbot = new Chatbot();
        chatbot.setAsk(ask);
        chatbot.setAnswer(answer);
        chatbotMapperService.add(chatbot);
    }

}
