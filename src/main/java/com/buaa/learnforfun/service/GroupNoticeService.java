package com.buaa.learnforfun.service;

import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.service.mapper.GroupNoticeMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupNoticeService {
    @Autowired
    GroupNoticeMapperService groupNoticeMapperService;

    public String announceGroupNotice(GroupNotice groupNotice) {
        GroupNotice tmp1 = new GroupNotice();
        tmp1.setGroupId(groupNotice.getGroupId());
        List<GroupNotice> temp = groupNoticeMapperService.find(tmp1);
        if (temp.size() == 0) {
            groupNoticeMapperService.add(groupNotice);
        } else {
            groupNotice.setId(temp.get(0).getId());
            groupNoticeMapperService.update(groupNotice);
        }
        return "success";
    }

    public GroupNotice getGroupNoticeById(String groupId) {
        GroupNotice groupNotice = new GroupNotice();
        groupNotice.setGroupId(groupId);
        List<GroupNotice> temp = groupNoticeMapperService.find(groupNotice);
        if (temp.size() != 0) {
            return temp.get(0);
        } else {
            groupNotice.setContent("");
            announceGroupNotice(groupNotice);
            return getGroupNoticeById(groupId);
        }
    }


}
