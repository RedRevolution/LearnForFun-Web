package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.ShareComment;
import com.buaa.learnforfun.entity.ShareCommentExample;
import java.util.List;

public interface ShareCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShareComment record);

    int insertSelective(ShareComment record);

    List<ShareComment> selectByExample(ShareCommentExample example);

    ShareComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareComment record);

    int updateByPrimaryKey(ShareComment record);
}