package com.buaa.learnforfun.controller.Fore.Group;

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
     * 获取群公告
     *
     * @param groupId
     * @return pre:每个群暂时只有一条群公告
     * response:
     */
    @ApiOperation(
            value = "获取群公告",
            notes = "pre:每个群暂时只有一条群公告"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public GroupNotice getGroupNoticeById(@PathVariable String groupId) {
        return groupNoticeService.getGroupNoticeById(groupId);
    }

    /**
     * 发布/修改群公告
     *
     * @param groupNotice
     * @return pre:进行该操作的用户是该群的管理员
     * need:groupId,userId,userName,content
     * response:
     * string=="success",发布成功刷新页面;
     * string=="error"||502,发布失败友好提示;
     */
    @ApiOperation(
            value = "发布/修改群公告",
            notes = "pre:进行该操作的用户是该群的管理员\n" +
                    "     * need:groupId,userId,userName,content\n" +
                    "     * response:\n" +
                    "     * string==\"success\",发布成功刷新页面;\n" +
                    "     * string==\"error\"||502,发布失败友好提示;")
    @PostMapping("announce")
    public String announceGroupNotice(@RequestBody GroupNotice groupNotice) {
        return groupNoticeService.announceGroupNotice(groupNotice);
    }

}
