package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
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

/**
 * 前台群组公告功能控制器
 */
@RestController
@RequestMapping("/api/group/notice")
public class GroupNoticeController extends BaseController {

    /**
     * 查看群公告
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "查看群公告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public GroupNotice getGroupNoticeById(@PathVariable String groupId) {
        return null;
    }

    /**
     * 发布/修改群公告
     *
     * @param groupNotice
     * @return
     */
    @ApiOperation(
            value = "发布/修改群公告",
            notes = "当前用户必须拥有管理员权限")
    @PostMapping("")
    public String announceGroupNotice(@RequestBody GroupNotice groupNotice) {
        return null;
    }

}
