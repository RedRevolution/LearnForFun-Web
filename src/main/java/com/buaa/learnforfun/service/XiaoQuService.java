package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.service.mapper.ChatbotMapperService;
import com.buaa.learnforfun.util.XiaoAi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiaoQuService {
    @Autowired
    ChatbotMapperService chatbotMapperService;

    public String askQuestion(String question) {
        //预设字段解决
        List<Chatbot> temp = chatbotMapperService.find(question);
        if (temp.size() != 0) {
            return temp.get(0).getAnswer();
        }
        //小i解决
        String ans = XiaoAi.getResponse(question);
        if (ans.equals("你好，我是小i机器人，很高兴认识你。")) {
            return "你好，我是小趣，很高兴认识你。";
        }
        if (ans.equals("亲爱的~你想了解的资讯都在这里，请\\u003ca href\\u0")) {
            return "小趣没有明白你的意思呢~问我一些更简单的问题吧！";
        }
        return XiaoAi.filter(XiaoAi.getResponse(question));
    }


}
