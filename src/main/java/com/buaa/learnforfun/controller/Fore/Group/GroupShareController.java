package com.buaa.learnforfun.controller.Fore.Group;

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
     * 查看群组的分享列表
     *
     * @param groupId
     * @return
     */
    @ApiOperation(
            value = "查看群组的分享列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "群组ID", required = true, dataType = "string"),
    })
    @GetMapping("{groupId}")
    public List<Share> getShareById(@PathVariable String groupId) {
        return shareService.listShare(groupId);
    }

    /**
     * 发布一条分享
     *
     * @param share
     * @return need:shareId,groupId,groupName,userId,userName,topic,content;
     * 这里的shareId=='K'或者shareId=='R',分别代表知识和资料
     * response:
     * string=="success",发布成功刷新页面;
     * string=="error"||502,发布失败友好提示;
     */
    @ApiOperation(
            value = "发布一条分享",
            notes = "need:groupId,groupName,userId,userName,topic,content;\n" +
                    "     * response:\n" +
                    "     * string==\"success\",发布成功刷新页面;\n" +
                    "     * string==\"error\"||502,发布失败友好提示;"
    )
    @PostMapping("post")
    public String postShare(@RequestBody Share share) {
        return shareService.postShare(share);
    }

    /**
     * 修改一条分享
     *
     * @param share
     * @return pre:进行该操作的userId==share.userId,仅可修改topic和content;
     * need:shareId,topic,content;
     * response:
     * string=="success",修改成功刷新页面;
     * string=="error"||502,修改失败友好提示;
     */
    @ApiOperation(
            value = "修改一条分享",
            notes = "pre:进行该操作的userId==share.userId,仅可修改topic和content;\n" +
                    "     * need:shareId,topic,content;\n" +
                    "     * response:\n" +
                    "     * string==\"success\",修改成功刷新页面;\n" +
                    "     * string==\"error\"||502,修改失败友好提示;"
    )
    @PostMapping("modify")
    public String modifyShare(@RequestBody Share share) {
        return shareService.modifyShare(share);
    }

    /**
     * 删除一条分享
     *
     * @param shareId
     * @return pre:进行该操作的userId==share.userId
     * response:
     * string=="success",删除成功刷新页面;
     * string=="error"||502,删除失败友好提示;
     */
    @ApiOperation(
            value = "删除一条分享",
            notes = "pre:进行该操作的userId==share.userId\n" +
                    "     * response:\n" +
                    "     * string==\"success\",删除成功刷新页面;\n" +
                    "     * string==\"error\"||502,删除失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
    })
    @GetMapping("delete/{shareId}")
    public String deleteShare(@PathVariable String shareId) {
        return shareService.deleteShare(shareId);
    }

    /**
     * 收藏一条分享
     *
     * @param shareId
     * @param userId
     * @return response:
     * string=="success",收藏成功刷新页面;
     * string=="exist",已经收藏过了;
     * string=="error"||502,收藏失败友好提示;
     */
    @ApiOperation(
            value = "收藏一条分享",
            notes = "response:\n" +
                    "     * string==\"success\",收藏成功刷新页面;\n" +
                    "     * string==\"exist\",已经收藏过了;\n" +
                    "     * string==\"error\"||502,收藏失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "收藏人ID", required = true, dataType = "string"),
    })
    @GetMapping("collect/{shareId}/{userId}")
    public String collectShare(@PathVariable String shareId, @PathVariable String userId) {
        return shareService.collectShare(shareId, userId);
    }

    /**
     * 点赞一条分享
     *
     * @param shareId
     * @return response:
     * string=="success",点赞成功刷新页面;
     * string=="error"||502,点赞失败友好提示;
     */
    @ApiOperation(
            value = "点赞一条分享",
            notes = "response:\n" +
                    "     * string==\"success\",点赞成功刷新页面;\n" +
                    "     * string==\"error\"||502,点赞失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
    })
    @GetMapping("favor/{shareId}")
    public String favorShare(@PathVariable String shareId) {
        return shareService.favorShare(shareId);
    }

    /**
     * 查看该分享下的评论列表
     *
     * @param shareId
     * @return
     */
    @ApiOperation(value = "查看该分享下的评论列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享Id", required = true, dataType = "string"),
    })
    @GetMapping("comment/{shareId}")
    public List<ShareComment> getCommentByshareId(@PathVariable String shareId) {
        return shareService.getCommentByshareId(shareId);
    }

    /**
     * 新增一条评论
     *
     * @param comment
     * @return need:shareId,userId,userName,content;
     * response:
     * string=="success",添加成功刷新页面;
     * string=="error"||502,添加失败友好提示;
     */
    @ApiOperation(
            value = "新增一条评论",
            notes = "need:shareId,userId,userName,content;\n" +
                    "     * response:\n" +
                    "     * string==\"success\",添加成功刷新页面;\n" +
                    "     * string==\"error\"||502,添加失败友好提示;"
    )
    @PostMapping("comment")
    public String addComment(@RequestBody ShareComment comment) {
        return shareService.addComment(comment);
    }

    /**
     * 删除一条评论
     *
     * @param commentId
     * @return need:commentId(实例中的id字段，查看评论列表时已获取)
     * response:
     * string=="success",删除成功刷新页面;
     * string=="error"||502,删除失败友好提示;
     */
    @ApiOperation(
            value = "删除一条评论",
            notes = "need:commentId(实例中的id字段，查看评论列表时已获取)\n" +
                    "     * response:\n" +
                    "     * string==\"success\",删除成功刷新页面;\n" +
                    "     * string==\"error\"||502,删除失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "评论ID", required = true, dataType = "long"),
    })
    @GetMapping("comment/delete/{commentId}")
    public String deleteComment(@PathVariable long commentId) {
        return shareService.deleteComment(commentId);
    }

    /**
     * 查看是否收藏该分享*
     *
     * @param shareId
     * @param userId
     * @return response:
     * string=="collected",收藏过;
     * string=="uncollected",没有收藏过;
     */
    @ApiOperation(
            value = "查看是否收藏该分享*",
            notes = "response:\n" +
                    "     * string==\"collected\",收藏过;\n" +
                    "     * string==\"uncollected\",没有收藏过;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shareId", value = "分享ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "收藏人ID", required = true, dataType = "string"),
    })
    @GetMapping("collect/check/{shareId}/{userId}")
    public String checkCollect(@PathVariable String shareId, @PathVariable String userId) {
        return shareService.checkCollect(shareId, userId);
    }

}
