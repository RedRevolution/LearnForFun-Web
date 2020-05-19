package com.buaa.learnforfun.controller.Fore.Group;

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
     * 获取群组最新的count条聊天记录
     *
     * @param groupId
     * @return response:
     * 可能不够count条，以返回的JSON中实际数目为准
     */
    @ApiOperation(
            value = "获取群组最新的count条聊天记录",
            notes = "response:\n" +
                    "     * 可能不够count条，以返回的JSON中实际数目为准"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "count", value = "聊天记录条数", required = true, dataType = "int"),
    })
    @GetMapping("{groupId}/{count}")
    public List<GroupMessage> getGroupMessageRecord(@PathVariable String groupId, int count) {
        return groupMessageService.getGroupMessageRecord(groupId, count);
    }

    /**
     * 获取群组messageId以前的count条聊天记录
     *
     * @param groupId
     * @param messageId
     * @param count
     * @return need:groupId,messageId(就是实例中的id字段),count
     * response:
     * 可能不够count条，以返回的JSON中实际数目为准
     */
    @ApiOperation(
            value = "获取群组messageId以前的count条聊天记录",
            notes = "need:groupId,messageId(就是实例中的id字段),count\n" +
                    "     * response:\n" +
                    "     * 可能不够count条，以返回的JSON中实际数目为准"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "messageId", value = "消息ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "count", value = "聊天记录条数", required = true, dataType = "int"),
    })
    @GetMapping("{groupId}/{messageId}/{count}")
    public List<GroupMessage> getRecordByMessageId(@PathVariable String groupId, long messageId, int count) {
        return groupMessageService.getRecordByMessageId(groupId, messageId, count);
    }

}
