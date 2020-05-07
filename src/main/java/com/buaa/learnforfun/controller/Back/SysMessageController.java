package com.buaa.learnforfun.controller.Back;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.SysMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 系统消息推送控制器
 */
@RestController
@RequestMapping("/api/sysmessage")
public class SysMessageController extends BaseController {

    /**
     * 查看系统消息
     *
     * @param sysMessageId
     * @return
     */
    @ApiOperation(
            value = "查看系统消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysMessageId", value = "系统消息ID", required = true, dataType = "string"),
    })
    @GetMapping("{sysMessageId}")
    public SysMessage getSysMessageById(@PathVariable String sysMessageId) {
        return null;
    }

    /**
     * 发布/修改系统消息
     *
     * @param sysMessage
     * @return
     */
    @ApiOperation(
            value = "发布/修改系统消息")
    @PostMapping("")
    public String announceSysMessage(@RequestBody SysMessage sysMessage) {
        return null;
    }

}
