package com.buaa.learnforfun.controller;

import com.buaa.learnforfun.dto.UserDto;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.KnowledgeShare;
import com.buaa.learnforfun.entity.User;
import com.buaa.learnforfun.entity.UserCollect;
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
 * 前台控制器
 */
@RestController
@RequestMapping("/api")
public class ForeController extends BaseController {

    @GetMapping("hello")
    public String hello() {
        return "hello,red!";
    }

    /**
     * 获取用户个人信息
     *
     * @return
     */
    @ApiOperation("通过微信号获取个人基本信息")
    @GetMapping("user/{Id}")
    public User getUserInfoByWechatId(@PathVariable String Id) {
        return userService.getUserByWechatId(Id);
    }

    /**
     * 用户注册(返回注册后的用户实例）
     *
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("user")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 获取用户的收藏列表
     *
     * @return
     */
    @ApiOperation("通过学号/工号获取个人收藏列表(知识分享)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "学号/工号", required = true, dataType = "int"),
    })
    @GetMapping("user/collect/{Id}")
    public List<KnowledgeShare> getUserCollectById(@PathVariable int Id) {
        return null;
    }

    /**
     * 用户收藏知识分享
     *
     * 收藏成功返回true，已存在记录返回false
     * @return
     */
    @ApiOperation("用户收藏一条知识分享")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "学号/工号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "ksId", value = "知识分享ID", required = true, dataType = "String"),
    })
    @PostMapping("user/collect")
    public boolean addKnowledgeShare(@RequestBody UserCollect userCollect) {
        return true;
    }

    /**
     * 获取用户已加入的群组列表
     *
     * @return
     */
    @ApiOperation("通过学号/工号获取加入的群组列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "学号/工号", required = true, dataType = "int"),
    })
    @GetMapping("user/group/{id}")
    public List<Group> getUserGroupById(@PathVariable int id) {
        return null;
    }

    /**
     * 获取群组的基本信息
     *
     * @return
     */
    @ApiOperation("通过群组ID获取群组基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "群组ID", required = true, dataType = "String"),
    })
    @GetMapping("group/{id}")
    public List<Group> getGroupInfoById(@PathVariable String id) {
        return null;
    }


}
