package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.entity.SysMessageExample;
import java.util.List;

public interface SysMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    List<SysMessage> selectByExample(SysMessageExample example);

    SysMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);
}