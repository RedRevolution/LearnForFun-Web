package com.buaa.learnforfun.controller.Fore.Group;


import com.buaa.learnforfun.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台小趣控制器
 */
@RestController
@RequestMapping("/api/xiaoqu")
public class XiaoQu extends BaseController {

    @ApiOperation(value = "获取小趣自我介绍")
    @GetMapping("")
    public String introduce() {
        return "你好呀~ 我是小趣，我可以帮你做好多好多事呢！让我们来聊天吧~";
    }

    @ApiOperation(value = "跟小趣聊天或者提问")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "用户发送的问题或聊天语句", required = true, dataType = "string"),
    })
    @GetMapping("{message}")
    public String ask(@PathVariable String message) {
        return xiaoQuService.askQuestion(message);
    }

}
