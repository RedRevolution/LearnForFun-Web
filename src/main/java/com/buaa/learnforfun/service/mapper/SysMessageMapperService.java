package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.SysMessageMapper;
import com.buaa.learnforfun.entity.SysMessage;
import com.buaa.learnforfun.entity.SysMessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMessageMapperService {
    @Autowired
    SysMessageMapper sysMessageMapper;

    public void add(SysMessage sysMessage) {
        sysMessageMapper.insertSelective(sysMessage);
    }

    public List<SysMessage> find(String userId) {
        SysMessageExample example = new SysMessageExample();
        example.or().andUserIdEqualTo(userId);
        example.setOrderByClause("id desc limit 1");
        return sysMessageMapper.selectByExample(example);
    }

    public List<SysMessage> findNotReply() {
        SysMessageExample example = new SysMessageExample();
        example.or().andIdIsNotNull().andReplyEqualTo("");
        example.setOrderByClause("id desc");
        return sysMessageMapper.selectByExample(example);
    }

    public List<SysMessage> findNotReply(String userId) {
        SysMessageExample example = new SysMessageExample();
        example.or().andUserIdEqualTo(userId).andReplyEqualTo("");
        example.setOrderByClause("id desc");
        return sysMessageMapper.selectByExample(example);
    }

    public void update(SysMessage sysMessage) {
        sysMessageMapper.updateByPrimaryKeySelective(sysMessage);
    }

}
