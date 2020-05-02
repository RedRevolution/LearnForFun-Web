package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台群组功能控制器
 */
@RestController
@RequestMapping("/api/group")
public class GroupController extends BaseController {

    /**
     * 获取群组基本信息
     * @param id
     * @return
     */
    @ApiOperation(
            value = "获取群组基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{id}")
    public Group getGroupInfoById(@PathVariable String id) {
        return null;
    }

    /**
     * 获取聊天记录
     * @param id
     * @return
     */
    @ApiOperation(
            value = "获取群组近来30条聊天记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("message/{id}")
    public List<GroupMessage> getGroupMessageRecord(@PathVariable String id) {
        return null;
    }



    @ApiOperation(
            value = "收藏一条知识分享",
            notes = "若返回\"success\"则收藏成功，若返回\"failure\"则已收藏过了")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "学号/工号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "ksId", value = "知识分享ID", required = true, dataType = "string"),
    })
    @PostMapping("collect/{id}/{ksId}")
    public String addKnowledgeShare(@PathVariable String Id,String ksId) {
        return null;
    }




}
