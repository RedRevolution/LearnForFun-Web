package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.entity.GroupNoticeExample;
import java.util.List;

public interface GroupNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupNotice record);

    int insertSelective(GroupNotice record);

    List<GroupNotice> selectByExample(GroupNoticeExample example);

    GroupNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupNotice record);

    int updateByPrimaryKey(GroupNotice record);
}