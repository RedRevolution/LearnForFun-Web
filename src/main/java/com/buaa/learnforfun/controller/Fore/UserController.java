package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.entity.Timetable;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.util.WeChatOpenId;
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
 * 前台用户功能控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    /**
     * 获取个人信息
     *
     * @param code
     * @return
     * response：
     * user.userId!="unbound",用户存在，返回完整的User实例，请将userId,userName作为全局缓存;
     * user.userId=="unbound",用户不存在，请保留user.openId用于后续绑定注册;
     */
    @ApiOperation(
            value = "获取个人信息",
            notes = "response：\n" +
                    "     * user.userId!=\"unbound\",用户存在，返回完整的User实例，请将userId,userName作为全局缓存;\n" +
                    "     * user.userId==\"unbound\",用户不存在，请保留user.openId用于后续绑定注册;")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "用户码", required = true, dataType = "string"),
    })
    @GetMapping("{code}")
    public User getUserInfoByCode(@PathVariable String code) {
        return userService.getUserByCode(code);
    }

    /**
     * 绑定个人信息
     *
     * @param user
     * @return
     * post：openId，userId，userName；
     * response：
     * string=="duplicate",学号/工号重复，请用户重新输入;
     * string=="success",绑定成功，请将用户userId作为全局缓存;
     */
    @ApiOperation(
            value = "绑定个人信息",
            notes = "post：openId，userId，userName；\n" +
                    "     * response：\n" +
                    "     * string==\"duplicate\",学号/工号重复，请用户重新输入;\n" +
                    "     * string==\"success\",绑定成功，请将用户userId作为全局缓存;")
    @PostMapping("")
    public String userInfoBind(@RequestBody User user) {
        User tmp = userService.bindUserInfo(user);
        if (tmp == null) return "success";
        else return "duplicate";
    }

    /**
     * 获取个人收藏列表
     *
     * @param userId
     * @return
     */
    @ApiOperation(
            value = "获取个人收藏列表",
            notes = "后端仅实现了知识分享的收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("collect/{userId}")
    public List<Share> getUserCollectById(@PathVariable String userId) {
        return null;
    }

    /**
     * 获取用户已加入的群组列表
     *
     * @param userId
     * @return
     */
    @ApiOperation(
            value = "获取已加入群组列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("group/{userId}")
    public List<Group> getUserGroupById(@PathVariable String userId) {
        return null;
    }

    /**
     * 获取个人日程列表
     *
     * @param userId
     * @return
     */
    @ApiOperation(
            value = "获取个人日程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("timetable/{userId}")
    public List<Timetable> getUserTimetableById(@PathVariable String userId) {
        return null;
    }

    /**
     * 获取系统推送消息
     */
    @ApiOperation(value = "获取系统推送消息")
    @GetMapping("sysMessage")
    public List<SysMessage> getUserSysMessageById() {
        return null;
    }

    /**
     * 用户反馈
     *
     * @param feedback
     * @return
     */
    @ApiOperation(
            value = "用户反馈",
            notes = "返回\"success\"成功，\"failure\"失败")
    @PostMapping("feedback")
    public String userFeedback(@RequestBody SysMessage feedback) {
        return null;
    }

}
