package com.buaa.learnforfun.controller.Fore;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.ShareComment;
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
 * 前台群组分享功能控制器
 */
@RestController
@RequestMapping("/api/group/share")
public class GroupShareController extends BaseController {

    /**
     * 查看群组分享列表
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "查看群组分享列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public List<Share> getShareById(@PathVariable String groupId) {
        return null;
    }

    /**
     * 发布/修改分享
     *
     * @param share
     * @return
     */
    @ApiOperation(
            value = "发布/修改分享")
    @PostMapping("")
    public String postShare(@RequestBody Share share) {
        return null;
    }

    /**
     * 删除一条分享
     */
    @ApiOperation(
            value = "删除一条分享")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
    })
    @GetMapping("delete/{shareId}")
    public String deleteShare(@PathVariable String shareId) {
        return null;
    }

    /**
     * 收藏一条分享
     *
     * @param shareId
     * @param userId
     * @return
     */
    @ApiOperation(
            value = "收藏一条分享",
            notes = "若返回\"success\"则收藏成功，若返回\"failure\"则已收藏过了")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "收藏人ID", required = true, dataType = "string"),
    })
    @GetMapping("collect/{shareId}/{userId}")
    public String collectShare(@PathVariable String shareId, String userId) {
        return null;
    }

    /**
     * 点赞一条分享
     *
     * @param shareId
     * @return
     */
    @ApiOperation(
            value = "点赞一条分享")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
    })
    @GetMapping("favor/{shareId}")
    public String favorShare(@PathVariable String shareId) {
        return null;
    }

    /**
     * 查看分享下的评论列表
     * @param shareId
     * @return
     */
    @ApiOperation(value = "查看分享评论列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享Id", required = true, dataType = "long"),
    })
    @GetMapping("comment/{shareId}")
    public List<ShareComment> getCommentByshareId(@PathVariable String shareId) {
        return null;
    }

    /**
     * 新增一条评论
     * @param comment
     * @return
     */
    @ApiOperation(
            value = "新增一条评论")
    @PostMapping("comment")
    public String addComment(@RequestBody ShareComment comment) {
        return null;
    }

    /**
     * 删除一条评论
     * @param commentId
     * @return
     */
    @ApiOperation(value = "删除一条评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "评论ID", required = true, dataType = "long"),
    })
    @GetMapping("comment/delete/{commentId}")
    public String deleteComment(@PathVariable String commentId) {
        return null;
    }

}
