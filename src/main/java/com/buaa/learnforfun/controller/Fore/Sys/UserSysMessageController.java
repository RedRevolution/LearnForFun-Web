package com.buaa.learnforfun.controller.Fore.Sys;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String userToSys(@PathVariable String userId,String content) {
        return sysService.userToSys(userId,content);
    }

    /**
     * 用户获取最新的系统消息
     * @return
     */
    @ApiOperation(value = "用户获取最新的系统消息*")
    @GetMapping("message")
    public String getSysMessage() {
        return sysService.getSysMessage();
    }

}
