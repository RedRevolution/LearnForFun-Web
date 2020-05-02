package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.Share;
import com.buaa.learnforfun.entity.ShareExample;
import java.util.List;

public interface ShareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}