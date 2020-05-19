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

    public List<SysMessage> find(SysMessage template) {
        SysMessageExample example = new SysMessageExample();
        if (template.getUserId() != null) {
            example.or().andUserIdEqualTo(template.getUserId());
        }
        return sysMessageMapper.selectByExample(example);
    }

    public List<SysMessage> find() {
        SysMessageExample example = new SysMessageExample();
        example.or().andIdIsNotNull();
        return sysMessageMapper.selectByExample(example);
    }

}
