package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.dao.GroupMessageMapper;
import com.buaa.learnforfun.dao.GroupNoticeMapper;
import com.buaa.learnforfun.dao.SelectCourseMapper;
import com.buaa.learnforfun.dao.ShareCommentMapper;
import com.buaa.learnforfun.dao.ShareMapper;
import com.buaa.learnforfun.dao.UserGroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import com.buaa.learnforfun.entity.GroupNotice;
import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.UserGroup;
import com.buaa.learnforfun.entity.UserGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupMessageMapper groupMessageMapper;
    @Autowired
    GroupNoticeMapper groupNoticeMapper;
    @Autowired
    ShareCommentMapper shareCommentMapper;
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    UserGroupMapper userGroupMapper;


    public Group getGroupInfo(String groupId) {
        GroupExample example = new GroupExample();
        example.or().andGroupIdEqualTo(groupId);
        List<Group> temp = groupMapper.selectByExample(example);
        return temp.get(0);
    }

//    public String dismissGroup(String groupId){
//        Group group = getGroupInfo(groupId);
//        groupMapper.deleteByPrimaryKey(group.getId())
//
//    }



}
