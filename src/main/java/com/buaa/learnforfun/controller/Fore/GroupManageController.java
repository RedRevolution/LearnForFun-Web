package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupNotice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台群组管理功能控制器
 */
@RestController
@RequestMapping("/api/group")
public class GroupManageController extends BaseController {

    /**
     * 获取群组基本信息
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "获取群组基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public Group getGroupInfoById(@PathVariable String groupId) {
        return null;
    }

    /**
     * 查询成员权限
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "查询群成员权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("check/{groupId}/{userId}")
    public String isAdministrator(@PathVariable String groupId,String userId) {
        return null;
    }

    /**
     * 修改群信息
     *
     * @param group
     * @return
     */
    @ApiOperation(
            value = "修改群信息")
    @PostMapping("modify")
    public String modifyGroupInfoById(@RequestBody Group group) {
        return null;
    }

    /**
     * 创建新群组
     *
     * @param group
     * @return
     */
    @ApiOperation(
            value = "创建新群组")
    @PostMapping("")
    public Group createGroup(@RequestBody Group group) {
        return null;
    }

    /**
     * 查找群组
     *
     * @param key
     * @return
     */
    @ApiOperation(
            value = "查找群组",
            notes = "支持群组名、创建者名、课程代码查找群组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "关键字", required = true, dataType = "string"),
    })
    @GetMapping("search/{key}")
    public List<Group> searchGroupByKey(@PathVariable String key) {
        return null;
    }

    /**
     * 加入群组/添加群成员
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "加入群组/添加群成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("join/{groupId}/{userId}")
    public String joinGroupById(@PathVariable String groupId, String userId) {
        return null;
    }

    /**
     * 退出群组/删除群成员
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "退出群组/删除群成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("exit/{groupId}/{userId}")
    public String exitGroupById(@PathVariable String groupId, String userId) {
        return null;
    }

}