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
     * @param code
     * @return
     */
    @ApiOperation(
            value = "获取个人信息",
            notes = "若返回的User实例中userId为\"unbound\"，则用户未绑定个人信息；请保留实例中的openId用于后续绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "用户码", required = true, dataType = "string"),
    })
    @GetMapping("{code}")
    public User getUserInfoByCode(@PathVariable String code) {
        String openId = WeChatOpenId.getOpenId("wxbe3bc73b7a961e66",code,"rjgc2020");
        return userService.getUserByOpenId(openId);
    }

    /**
     * 绑定个人信息
     * @param user
     * @return
     */
    @ApiOperation(
            value = "绑定个人信息",
            notes = "若返回User实例中的userId为\"duplicate\"，则学号/工号重复，让用户重新输入")
    @PostMapping("")
    public User userInfoBind(@RequestBody User user) {
        return userService.bindUserInfo(user);
    }

    /**
     * 获取个人收藏列表
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
