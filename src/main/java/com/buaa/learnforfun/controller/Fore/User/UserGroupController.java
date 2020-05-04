package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
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
 * 前台用户群组控制器
 */
@RestController
@RequestMapping("/api/user/group")
public class UserGroupController extends BaseController {

    /**
     * 获取用户已加入的群组列表
     *
     * @param userId
     * @return
     *
     * response:
     * Group.groupId[0]=='O'表示这是一个官方群组，courseCode字段为课程代码；
     * Group.groupId[0]=='I'表示这是一个兴趣小组，courseCode字段为空；
     * 点进一个群组时请缓存该群组的groupId，用于群组聊天；
     */
    @ApiOperation(
            value = "获取用户已加入的群组列表",
            notes = "response:\n" +
                    "     * Group.groupId[0]=='O'表示这是一个官方群组，courseCode字段为课程代码；\n" +
                    "     * Group.groupId[0]=='I'表示这是一个兴趣小组，courseCode字段为空；\n" +
                    "     * 点进一个群组时请缓存该群组的groupId，用于群组聊天；")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("{userId}")
    public List<Group> getUserGroupById(@PathVariable String userId) {
        return null;
    }

    /**
     * 用户创建群组
     *
     * @param group
     * @return
     *
     * need:
     * 官方群组:groupName,groupOwnerId,groupOwnerName,courseCode;
     * 兴趣小组:groupName,groupOwnerId,groupOwnerName,courseCode=="unofficial";
     * (groupIntrod为可选字段，用户填写了就加上，没填写就置"")
     * response:
     * group.groupId!="failure",创建成功,将返回的group实例添进缓存列表,更新界面;
     * group.groupId=="failure"||502,创建失败,友好提示;
     */
    @ApiOperation(
            value = "用户创建群组",
            notes = "need:\n" +
                    "     * 官方群组:groupName,groupOwnerId,groupOwnerName,courseCode;\n" +
                    "     * 兴趣小组:groupName,groupOwnerId,groupOwnerName,courseCode==\"unofficial\";\n" +
                    "     * (groupIntrod为可选字段，用户填写了就加上，没填写就置\"\")\n" +
                    "     * response:\n" +
                    "     * group.groupId!=\"failure\",创建成功,将返回的group实例添进缓存列表,更新界面;\n" +
                    "     * group.groupId==\"failure\"||502,创建失败,友好提示;"
    )
    @PostMapping("")
    public Group createGroup(@RequestBody Group group) {
        return null;
    }

    /**
     * 用户搜索群组
     *
     * @param key
     * @return
     *
     * pre:暂支持群组名、创建者名、课程代码查找群组
     * response:
     * 搜索到的有相关记录的group列表
     *
     */
    @ApiOperation(
            value = "用户搜索群组",
            notes = "pre:暂支持群组名、创建者名、课程代码查找群组\n" +
                    "     * response:\n" +
                    "     * 搜索到的有相关记录的group列表"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "索引关键词", required = true, dataType = "string"),
    })
    @GetMapping("search/{key}")
    public List<Group> searchGroupByKey(@PathVariable String key) {
        return null;
    }

    /**
     * 用户加入群组
     *
     * @param groupId
     * @return
     * response:
     * string=="success",成功入群,更新列表;
     * string=="error"||502,失败,友好提示;
     *
     */
    @ApiOperation(
            value = "用户加入群组",
            notes = "response:\n" +
                    "     * string==\"success\",成功入群,更新列表;\n" +
                    "     * string==\"error\"||502,失败,友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("join/{groupId}/{userId}")
    public String joinGroupById(@PathVariable String groupId, String userId) {
        return null;
    }

    /**
     * 用户退出群组
     *
     * @param groupId
     * @return
     * response:
     * string=="success",成功退群,更新列表;
     * string=="error"||502,失败,友好提示;
     *
     */
    @ApiOperation(
            value = "用户退出群组",
            notes = "response:\n" +
                    "     * string==\"success\",成功退群,更新列表;\n" +
                    "     * string==\"error\"||502,失败,友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("exit/{groupId}/{userId}")
    public String exitGroupById(@PathVariable String groupId, String userId) {
        return null;
    }


}
