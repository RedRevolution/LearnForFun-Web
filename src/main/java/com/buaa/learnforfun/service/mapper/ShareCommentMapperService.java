package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.ShareCommentMapper;
import com.buaa.learnforfun.entity.ShareComment;
import com.buaa.learnforfun.entity.ShareCommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareCommentMapperService {
    @Autowired
    ShareCommentMapper shareCommentMapper;

    public void add(ShareComment shareComment) {
        shareCommentMapper.insertSelective(shareComment);
    }

    public List<ShareComment> find(ShareComment template) {
        ShareCommentExample example = new ShareCommentExample();
        ShareCommentExample.Criteria criteria = example.createCriteria();
        if (template.getShareId() != null) {
            criteria.andShareIdEqualTo(template.getShareId());
        }
        if (template.getUserId() != null) {
            criteria.andUserIdEqualTo(template.getUserId());
        }
        if (template.getUserName() != null) {
            criteria.andUserNameEqualTo(template.getUserName());
        }
        if (template.getContent() != null) {
            criteria.andContentEqualTo(template.getContent());
        }
        return shareCommentMapper.selectByExample(example);
    }

    public void delete(ShareComment shareComment) {
        if (shareComment.getId() != null) {
            shareCommentMapper.deleteByPrimaryKey(shareComment.getId());
        } else {
            List<ShareComment> temp = find(shareComment);
            for (ShareComment i : temp) {
                delete(i);
            }
        }
    }

}
