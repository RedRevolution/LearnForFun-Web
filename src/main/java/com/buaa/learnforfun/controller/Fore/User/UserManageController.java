package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.User;
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
 * 前台用户管理控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserManageController extends BaseController {
    @GetMapping("hello")
    public String hello() {
        return "hello,red";
    }

    /**
     * 获取个人信息
     *
     * @param code
     * @return response：
     * user.userId!="unbound",用户存在，返回完整的User实例，请将userId,userName作为全局缓存;
     * user.userId=="unbound",用户不存在，请保留openId用于后续绑定;
     */
    @ApiOperation(
            value = "获取个人信息",
            notes = "response：\n" +
                    "     * user.userId!=\"unbound\",用户存在，返回完整的User实例，请将userId,userName作为全局缓存;\n" +
                    "     * user.userId==\"unbound\",用户不存在，请保留openId用于后续绑定;"
    )
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
     * @return pre：绑定时需让用户反复确定输入；
     * need：openId，userId，userName；
     * response：
     * string=="duplicate",学号/工号已存在，请用户重新输入;
     * string=="success",绑定成功，请将用户userId和userName作为全局缓存;
     */
    @ApiOperation(
            value = "绑定个人信息",
            notes = "pre：绑定时需让用户反复确定输入；\n" +
                    "     * need：openId，userId，userName；\n" +
                    "     * response：\n" +
                    "     * string==\"duplicate\",学号/工号已存在，请用户重新输入;\n" +
                    "     * string==\"success\",绑定成功，请将用户userId和userName作为全局缓存;"
    )
    @PostMapping("")
    public String userInfoBind(@RequestBody User user) {
        User tmp = userService.bindUserInfo(user);
        if (tmp != null) return "success";
        else return "duplicate";
    }

    /**
     * 修改个人信息
     *
     * @param user
     * @return pre：修改时需提示"注意：将删除数据库中所有记录！"，前端若实现该功能可以设置一个不起眼的入口，因为不鼓励修改；
     * need：openId，userId，userName；
     * response：
     * string=="duplicate",修改的学号/工号已存在，请用户重新输入;
     * string=="success",修改成功，请将新的userId和userName作为全局缓存;
     */
    @ApiOperation(
            value = "修改个人信息",
            notes = "pre：修改时需提示\"注意：将删除数据库中所有记录！\"，前端若实现该功能可以设置一个不起眼的入口，因为不鼓励修改；\n" +
                    "     * need：openId，userId，userName；\n" +
                    "     * response：\n" +
                    "     * string==\"duplicate\",修改的学号/工号已存在，请用户重新输入;\n" +
                    "     * string==\"success\",修改成功，请将新的userId和userName作为全局缓存;"
    )
    @PostMapping("modify")
    public String modifyUserInfo(@RequestBody User user) {
        return null;
    }


    /**
     * 账号注销
     *
     * @param userId
     * @return pre:出于用户体验而设计，前端可根据进度实现
     * response:
     * string=="success",注销成功;
     * string=="error"||502,发生错误无法注销;
     */
    @ApiOperation(
            value = "账号注销",
            notes = "pre:出于用户体验而设计，前端可根据进度实现\n" +
                    "     * response:\n" +
                    "     * string==\"success\",注销成功;\n" +
                    "     * string==\"error\"||502,发生错误无法注销;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string"),
    })
    @GetMapping("delete/{userId}")
    public String delete(@PathVariable String userId) {
        return null;
    }

}
