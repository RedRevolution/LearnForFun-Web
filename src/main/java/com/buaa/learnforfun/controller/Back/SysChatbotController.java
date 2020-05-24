package com.buaa.learnforfun.controller.Back;


import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.dto.JsonData;
import com.buaa.learnforfun.dto.PageResult;
import com.buaa.learnforfun.entity.Chatbot;
import com.buaa.learnforfun.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/chatbot")
public class SysChatbotController extends BaseController {


    @Autowired
    private SysService sysService;

    /**
     * 查看系统消息
     *
     * @param
     * @return
     */
    @GetMapping
    @ResponseBody
    public PageResult listPage(String ask) {
        List<Chatbot> chatbots = sysService.findChatbot(ask);
        return new PageResult(chatbots.size(), chatbots);
    }

    /**
     * 发布/修改系统消息
     *
     * @param
     * @return
     */
    @PostMapping
    @ResponseBody
    public JsonData save(String ask,String answer) {
        sysService.setChatbot(ask,answer);
        return JsonData.success();
    }
    /**
     * 发布/修改系统消息
     *
     * @param
     * @return
     */
    @PostMapping("/remove")
    @ResponseBody
    public JsonData remove(Long id) {
        sysService.deleteChatbot(id);
        return JsonData.success();
    }

}
