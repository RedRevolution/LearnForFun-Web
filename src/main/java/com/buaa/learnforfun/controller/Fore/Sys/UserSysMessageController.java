package com.buaa.learnforfun.controller.Fore.Sys;

import com.buaa.learnforfun.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sys")
public class UserSysMessageController extends BaseController {

    /**
     * 用户向后台发送消息*
     *
     * @param
     * @return
     */
    @ApiOperation(value = "用户向后台发送消息*")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "content", value = "消息内容", required = true, dataType = "string"),
    })
    @GetMapping("usermessage/{userId}/{content}")
    public String sendToBack(@PathVariable String userId,@PathVariable String content) {
        return sysService.sendToBack(userId,content);
    }

    /**
     * 用户获取最新的系统消息
     * @return
     */
    @ApiOperation(value = "用户获取最新的系统消息*")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("message/{userId}")
    public List<String> getBackMessage(@PathVariable String userId) {
        return sysService.getBackMessage(userId);
    }

}
