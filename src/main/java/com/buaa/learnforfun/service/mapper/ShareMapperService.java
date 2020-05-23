package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.ShareMapper;
import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.ShareComment;
import com.buaa.learnforfun.entity.ShareExample;
import com.buaa.learnforfun.entity.UserCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareMapperService {
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    ShareCommentMapperService shareCommentMapperService;
    @Autowired
    UserCollectMapperService userCollectMapperService;

    public void add(Share share){
        shareMapper.insertSelective(share);
    }

    public List<Share> find(Share template) {
        ShareExample example = new ShareExample();
        ShareExample.Criteria criteria = example.createCriteria();
        if (template.getShareId() != null) {
            criteria.andShareIdEqualTo(template.getShareId());
        }
        if (template.getGroupId() != null) {
            criteria.andGroupIdEqualTo(template.getGroupId());
        }
        if (template.getUserId() != null) {
            criteria.andUserIdEqualTo(template.getUserId());
        }
        if (template.getUserName() != null) {
            criteria.andUserNameEqualTo(template.getUserName());
        }
        if (template.getGroupName() != null) {
            criteria.andGroupNameEqualTo(template.getGroupName());
        }
        if (template.getTopic() != null) {
            criteria.andTopicEqualTo(template.getTopic());
        }
        if (template.getContent() != null) {
            criteria.andContentEqualTo(template.getContent());
        }
        example.setOrderByClause("id desc");
        return shareMapper.selectByExample(example);
    }

    public void delete(Share share) {
        if (share.getId() != null) {
            shareMapper.deleteByPrimaryKey(share.getId());
            //删除评论记录
            ShareComment shareComment = new ShareComment();
            shareComment.setShareId(share.getShareId());
            shareCommentMapperService.delete(shareComment);
            //删除收藏记录
            UserCollect userCollect = new UserCollect();
            userCollect.setShareId(share.getShareId());
            userCollectMapperService.delete(userCollect);
        } else {
            List<Share> temp = find(share);
            for (Share i : temp) {
                delete(i);
            }
        }
    }

    public void update(Share share) {
        shareMapper.updateByPrimaryKeySelective(share);
    }

}
