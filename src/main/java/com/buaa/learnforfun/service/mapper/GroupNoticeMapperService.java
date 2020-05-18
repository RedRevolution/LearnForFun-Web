package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.GroupNoticeMapper;
import com.buaa.learnforfun.entity.GroupNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupNoticeMapperService {
    @Autowired
    GroupNoticeMapper groupNoticeMapper;

}
