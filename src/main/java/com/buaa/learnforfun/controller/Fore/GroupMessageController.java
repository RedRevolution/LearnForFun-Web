package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.GroupMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台群组消息功能控制器
 */
@RestController
@RequestMapping("/api/group/message")
public class GroupMessageController extends BaseController {
    /**
     * 获取群组最新30条聊天记录
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "获取群组最新30条聊天记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("message/{groupId}")
    public List<GroupMessage> getGroupMessageRecord(@PathVariable String groupId) {
        return null;
    }

    /**
     * 获取该群组messageId前10条聊天记录
     * @param groupId
     * @param messageId
     * @return
     */
    @ApiOperation(
            value = "获取该群组messageId前10条聊天记录",
            notes = "可能不够10条")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "messageId", value = "消息ID", required = true, dataType = "long"),
    })
    @GetMapping("message/{groupId}/{messageId}")
    public List<GroupMessage> getRecordByMessageId(@PathVariable String groupId,String messageId) {
        return null;
    }

    /**
     * websocket
     */
}
