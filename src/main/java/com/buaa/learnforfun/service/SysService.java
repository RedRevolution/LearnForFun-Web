package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.service.mapper.ChatbotMapperService;
import com.buaa.learnforfun.service.mapper.SysMessageMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysService {
    @Autowired
    SysMessageMapperService sysMessageMapperService;
    @Autowired
    ChatbotMapperService chatbotMapperService;

    public String sendToBack(String userId, String content) {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setUserId(userId);
        sysMessage.setContent(content);
        sysMessageMapperService.add(sysMessage);
        return "success";
    }

    public List<String> getBackMessage(String userId) {
        //搜索最新的系统消息
        List<SysMessage> sys = sysMessageMapperService.find("00000000");
        //搜索对用户的最新reply
        List<SysMessage> rep = sysMessageMapperService.find(userId);
        List<String> ans = new ArrayList<>();
        if (sys.size() != 0) ans.add(sys.get(0).getContent());
        if (rep.size() != 0 && !rep.get(0).getReply().equals("")) ans.add(rep.get(0).getReply());
        return ans;
    }

    //后台发布系统消息
    public void releaseSysMessage(String content) {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setUserId("00000000");
        sysMessage.setContent(content);
        sysMessage.setReply("NoNeedReply");
        sysMessageMapperService.add(sysMessage);
    }

    //后台获取未回复的用户反馈
    public List<SysMessage> getAllUsrMessage() {
        List<SysMessage> temp = sysMessageMapperService.findNotReply();
        Map<String, SysMessage> userMessage = new HashMap<>();
        for (SysMessage i : temp) {
            if (userMessage.containsKey(i.getUserId())) {
                SysMessage sysMessage = userMessage.get(i.getUserId());
                sysMessage.setContent(sysMessage.getContent() + " " + i.getContent());
                userMessage.put(i.getUserId(), sysMessage);
            } else {
                userMessage.put(i.getUserId(), i);
            }
        }
        return new ArrayList<>(userMessage.values());
    }

    //后台回复用户的反馈(注意不超过256个字)
    public void replyToUser(String userId, String reply) {
        List<SysMessage> notReply = sysMessageMapperService.findNotReply(userId);
        for (SysMessage i : notReply) {
            i.setReply(reply);
            sysMessageMapperService.update(i);
        }
    }

    //后台为聊天机器人预设字段
    public void setChatbot(String ask, String answer) {
        Chatbot chatbot = new Chatbot();
        chatbot.setAsk(ask);
        chatbot.setAnswer(answer);
        chatbotMapperService.add(chatbot);
    }

    //后台获取所有预设字段
    public List<Chatbot> getAllChatbot() {
        return chatbotMapperService.find();
    }

}
