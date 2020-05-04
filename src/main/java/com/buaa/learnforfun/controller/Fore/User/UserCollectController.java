package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Share;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 前台用户收藏控制器
 */
@RestController
@RequestMapping("/api/user/collect")
public class UserCollectController extends BaseController {
    /**
     * 获取个人收藏的分享列表
     *
     * @param userId
     * @return
     * pre:包含知识分享和资料分享
     * response:
     * Share.groupName和Share.userName对应分享群和分享人；
     * Share.shareId[0]=='K'表示这是一个知识分享，content字段是知识分享内容；
     * Share.shareId[0]=='R'表示这是一个资料分享，content字段是资源链接；
     */
    @ApiOperation(
            value = "获取个人收藏的分享列表",
            notes = "pre:包含知识分享和资料分享\n" +
                    "     * response:\n" +
                    "     * Share.groupName和Share.userName对应分享群和分享人；\n" +
                    "     * Share.shareId[0]=='K'表示这是一个知识分享，content字段是知识分享内容；\n" +
                    "     * Share.shareId[0]=='R'表示这是一个资料分享，content字段是资源链接；"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("{userId}")
    public List<Share> getUserCollectById(@PathVariable String userId) {
        return null;
    }

    /**
     * 取消收藏
     *
     * @param shareId
     * @param userId
     * @return
     *
     * response:
     * string=="success",操作成功；
     * string=="error"||502,发生错误；
     */
    @ApiOperation(
            value = "取消收藏",
            notes = "response:\n" +
                    "     * string==\"success\",操作成功；\n" +
                    "     * string==\"error\"||502,发生错误；"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("cancel/{shareId}/{userId}")
    public String cancelCollectById(@PathVariable String shareId,String userId) {
        return null;
    }

}
