package com.buaa.learnforfun.controller.Back;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.dto.JsonData;
import com.buaa.learnforfun.dto.PageResult;
import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/sysmessage")
public class SysMessageController extends BaseController {


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
    public PageResult listPage() {
        List<SysMessage> sysMessages = sysService.getAllUsrMessage();
        return new PageResult(sysMessages.size(), sysMessages);
    }

    /**
     * 发布/修改系统消息
     *
     * @param
     * @return
     */
    @PostMapping
    @ResponseBody
    public JsonData save(String content) {
        sysService.releaseMessage(content);
        return JsonData.success();
    }

    @PostMapping("/replyToUser")
    @ResponseBody
    public JsonData replyToUser(String userId,String reply){
        sysService.replyToUser(userId,reply);
        return JsonData.success();
    }
}
