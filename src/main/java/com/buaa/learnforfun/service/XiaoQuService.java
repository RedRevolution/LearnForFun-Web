package com.buaa.learnforfun.service;

import com.buaa.learnforfun.util.XiaoAi;
import org.springframework.stereotype.Service;

@Service
public class XiaoQuService {

    public String askQuestion(String question) {
        return XiaoAi.getResponse(question);
    }


}
