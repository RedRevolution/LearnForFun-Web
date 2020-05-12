package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.ShareCommentMapper;
import com.buaa.learnforfun.dao.ShareMapper;
import com.buaa.learnforfun.dao.UserCollectMapper;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.ShareComment;
import com.buaa.learnforfun.entity.ShareExample;
import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserCollectExample;
import com.sun.javafx.UnmodifiableArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShareService {
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    ShareCommentMapper shareCommentMapper;
    @Autowired
    UserCollectMapper userCollectMapper;

    public List<Share> listShare(String groupId) {
        ShareExample example = new ShareExample();
        example.or().andGroupIdEqualTo(groupId);
        List<Share> ans = shareMapper.selectByExample(example);
        return ans;
    }

    public String postShare(Share share) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String shareId = share.getShareId() + dtf.format(LocalDateTime.now()) + share.getUserId();
        share.setShareId(shareId);
        shareMapper.insertSelective(share);
        return "success";
    }

    public String addComment(ShareComment shareComment) {
        shareCommentMapper.insertSelective(shareComment);
        return "success";
    }

    public String collectShare(String shareId, String userId) {
        UserCollectExample example = new UserCollectExample();
        example.or().andUserIdEqualTo(userId).andShareIdEqualTo(shareId);
        List<UserCollect> temp = userCollectMapper.selectByExample(example);
        if (temp.size() == 0) {
            UserCollect userCollect = new UserCollect();
            userCollect.setUserId(userId);
            userCollect.setShareId(shareId);
            userCollectMapper.insertSelective(userCollect);
            return "success";
        } else {
            return "exist";
        }
    }

    public List<Share> getCollectShare(String userId) {
        UserCollectExample example = new UserCollectExample();
        example.or().andUserIdEqualTo(userId);
        List<UserCollect> collects = userCollectMapper.selectByExample(example);
        List<Share> ans = new ArrayList<>();
        for (UserCollect i : collects) {
            ShareExample example1 = new ShareExample();
            example1.or().andShareIdEqualTo(i.getShareId());
            ans.addAll(shareMapper.selectByExample(example1));
        }
        return ans;
    }

}
