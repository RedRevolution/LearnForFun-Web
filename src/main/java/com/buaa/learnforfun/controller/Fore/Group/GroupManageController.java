package com.buaa.learnforfun.controller.Fore.Group;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.UserGroup;
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
    @ApiOperation(value = "获取群组基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public Group getGroupInfoById(@PathVariable String groupId) {
        return groupService.getGroupInfo(groupId);
    }

    /**
     * 修改群组基本信息*
     *
     * @param group
     * @return
     * pre:执行该操作的用户是该群管理员，且仅可修改groupName,groupIntrod字段
     * need:post的group实体应该包含所有字段的完整信息
     */
    @ApiOperation(
            value = "修改群组基本信息*",
            notes = "pre:执行该操作的用户是该群管理员，且仅可修改groupName,groupIntrod字段\n" +
                    "     * need:post的group实体应该包含所有字段的完整信息"
    )
    @PostMapping("modify")
    public String modifyGroupInfo(@RequestBody Group group) {
        return groupService.modifyGroupInfo(group);
    }

    /**
     * 查看群成员列表(包含相应的管理权限)*
     */
    @ApiOperation(
            value = "查看群成员列表(包含相应的管理权限)*"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("member/{groupId}")
    public List<UserGroup> getGroupMember(@PathVariable String groupId) {
        return groupService.getGroupMember(groupId);
    }

    /**
     * 查询群组成员权限
     *
     * @param groupId
     * @return pre:拥有管理员权限的用户可以修改群组信息，添加删除群成员，发布群公告；
     * 建议在用户点进群组时进行查询，缓存权限
     * response:
     * string=="nongroupmember",该用户非该群成员;
     * string=="administrator",该用户为该群的管理员;
     * string=="groupmember",该用户为该群的普通成员;
     */
    @ApiOperation(
            value = "查询群组成员权限",
            notes = "pre:拥有管理员权限的用户可以修改群组信息，添加删除群成员，发布群公告；\n" +
                    "     * 建议在用户点进群组时进行查询，缓存权限\n" +
                    "     * response:\n" +
                    "     * string==\"nongroupmember\",该用户非该群成员;\n" +
                    "     * string==\"administrator\",该用户为该群的管理员;\n" +
                    "     * string==\"groupmember\",该用户为该群的普通成员;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("authority/{groupId}/{userId}")
    public String isAdministrator(@PathVariable String groupId, String userId) {
        return groupService.isAdministrator(groupId, userId);
    }

    /**
     * 添加群成员*
     *
     * @param
     * @return
     * pre:执行该操作的用户是该群管理员
     * need:UserGroup的所有字段,isAdmin一般默认为false
     * response:
     * string=="success",添加成功;
     * string=="exist",成员已存在该群;
     * string=="error"||502,添加失败友好提示;
     */
    @ApiOperation(
            value = "添加群成员*",
            notes = "pre:执行该操作的用户是该群管理员\n" +
                    "     * need:UserGroup的所有字段,isAdmin一般默认为false\n" +
                    "     * response:\n" +
                    "     * string==\"success\",添加成功;\n" +
                    "     * string==\"exist\",成员已存在该群;\n" +
                    "     * string==\"error\"||502,添加失败友好提示;"
    )
    @PostMapping("member/add")
    public String addGroupMemberById(@RequestBody UserGroup userGroup) {
        return groupService.addGroupMember(userGroup);
    }

    /**
     * 删除群成员
     *
     * @param groupId
     * @return pre:执行该操作的用户是该群管理员
     * response:
     * string=="success",删除成功;
     * string=="nonexist",成员已不在该群;
     * string=="error"||502,删除失败友好提示;
     */
    @ApiOperation(
            value = "删除群成员",
            notes = "pre:执行该操作的用户是该群管理员\n" +
                    "     * response:\n" +
                    "     * string==\"success\",删除成功;\n" +
                    "     * string==\"nonexist\",成员已不在该群;\n" +
                    "     * string==\"error\"||502,删除失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("member/delete/{groupId}/{userId}")
    public String delelteGroupMemberById(@PathVariable String groupId, String userId) {
        return groupService.delelteGroupMember(groupId, userId);
    }

    /**
     * 解散群组
     *
     * @param groupId
     * @return pre:执行该操作的用户必须是该群的创建者！执行前应将当前userId与group中的
     * groupOwnerId进行对比，并提示："解散后将删除所有记录！"
     * response:
     * string=="success",解散成功请刷新页面;
     * string=="error"||502,解散失败友好提示;
     */
    @ApiOperation(
            value = "解散群组",
            notes = "pre:执行该操作的用户必须是该群的创建者！执行前应将当前userId与group中的\n" +
                    "     * groupOwnerId进行对比，并提示：\"解散后将删除所有记录！\"\n" +
                    "     * response:\n" +
                    "     * string==\"success\",解散成功请刷新页面;\n" +
                    "     * string==\"error\"||502,解散失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("dismiss/{groupId}")
    public String dismissGroupById(@PathVariable String groupId) {
        return groupService.dismissGroup(groupId);
    }

}