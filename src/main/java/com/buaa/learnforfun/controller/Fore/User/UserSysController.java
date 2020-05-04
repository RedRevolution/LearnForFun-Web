package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.entity.SysMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台用户系统与反馈控制器
 */
@RestController
@RequestMapping("/api/user/sys")
public class UserSysController {

    /**
     * 获取系统推送消息
     *
     * @return
     * pre:系统推送暂时为推送到所有用户，后期可改进为单点推送
     */
    @ApiOperation(
            value = "获取系统推送消息",
            notes = "pre:系统推送暂时为推送到所有用户，后期可改进为单点推送"
    )
    @GetMapping("message")
    public List<SysMessage> getSysMessage() {
        return null;
    }

    /**
     * 用户反馈
     *
     * @param feedback
     * @return
     * pre:用户可向系统反馈意见，增强用户体验
     * response:
     * string=="success",收到反馈;
     * string=="error"||502,系统错误;
     */
    @ApiOperation(
            value = "用户反馈",
            notes = "pre:用户可向系统反馈意见，增强用户体验\n" +
                    "     * response:\n" +
                    "     * string==\"success\",收到反馈;\n" +
                    "     * string==\"error\"||502,系统错误;"
    )
    @PostMapping("feedback")
    public String userFeedback(@RequestBody SysMessage feedback) {
        return null;
    }
}
