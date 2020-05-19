package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.ShareCommentMapper;
import com.buaa.learnforfun.dao.ShareMapper;
import com.buaa.learnforfun.dao.UserCollectMapper;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.ShareComment;
import com.buaa.learnforfun.entity.ShareExample;
import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserCollectExample;
import com.buaa.learnforfun.service.mapper.ShareCommentMapperService;
import com.buaa.learnforfun.service.mapper.ShareMapperService;
import com.buaa.learnforfun.service.mapper.UserCollectMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShareService {
    @Autowired
    ShareMapperService shareMapperService;
    @Autowired
    UserCollectMapperService userCollectMapperService;
    @Autowired
    ShareCommentMapperService shareCommentMapperService;

    public List<Share> listShare(String groupId) {
        Share share = new Share();
        share.setGroupId(groupId);
        return shareMapperService.find(share);
    }

    public String postShare(Share share) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String shareId = share.getShareId() + dtf.format(LocalDateTime.now()) + share.getUserId();
        share.setShareId(shareId);
        shareMapperService.add(share);
        return "success";
    }

    public String deleteShare(String shareId) {
        Share share = new Share();
        share.setShareId(shareId);
        shareMapperService.delete(share);
        return "success";
    }

    public String addComment(ShareComment shareComment) {
        shareCommentMapperService.add(shareComment);
        return "success";
    }

    public String favorShare(String shareId) {
        Share share = new Share();
        share.setShareId(shareId);
        List<Share> temp = shareMapperService.find(share);
        Share tmp = temp.get(0);
        int count = tmp.getLikesNum();
        tmp.setLikesNum(count + 1);
        shareMapperService.update(tmp);
        return "success";
    }


    public String collectShare(String shareId, String userId) {
        UserCollect userCollect = new UserCollect();
        userCollect.setShareId(shareId);
        userCollect.setUserId(userId);
        List<UserCollect> temp = userCollectMapperService.find(userCollect);
        if (temp.size() == 0) {
            UserCollect tmp = new UserCollect();
            tmp.setUserId(userId);
            tmp.setShareId(shareId);
            userCollectMapperService.add(tmp);
            return "success";
        } else {
            return "exist";
        }
    }

    public List<Share> getCollectShare(String userId) {
        UserCollect userCollect = new UserCollect();
        userCollect.setUserId(userId);
        List<UserCollect> temp = userCollectMapperService.find(userCollect);
        List<Share> ans = new ArrayList<>();
        for (UserCollect i : temp) {
            Share share = new Share();
            share.setShareId(i.getShareId());
            ans.addAll(shareMapperService.find(share));
        }
        return ans;
    }

    public String cancelCollectById(String shareId, String userId) {
        UserCollect userCollect = new UserCollect();
        userCollect.setShareId(shareId);
        userCollect.setUserId(userId);
        userCollectMapperService.delete(userCollect);
        return "success";
    }

    public List<ShareComment> getCommentByshareId(String shareId) {
        ShareComment shareComment = new ShareComment();
        shareComment.setShareId(shareId);
        return shareCommentMapperService.find(shareComment);
    }

    public String deleteComment(long commentId) {
        ShareComment shareComment = new ShareComment();
        shareComment.setId(commentId);
        shareCommentMapperService.delete(shareComment);
        return "success";
    }

    public String checkCollect(String shareId, String userId) {
        UserCollect userCollect = new UserCollect();
        userCollect.setUserId(userId);
        userCollect.setShareId(shareId);
        if (userCollectMapperService.find(userCollect).size() == 0) {
            return "uncollected";
        } else {
            return "collected";
        }
    }

}
