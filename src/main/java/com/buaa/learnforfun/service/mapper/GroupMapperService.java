package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.GroupMapper;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMapperService {
    @Autowired
    GroupMapper groupMapper;

    public void add(Group group) {
        groupMapper.insertSelective(group);
    }

    public Group findByCourse(Group group) {
        GroupExample example = new GroupExample();
        example.or().andCourseCodeEqualTo(group.getCourseCode()).andGroupNameEqualTo(group.getGroupName());
        List<Group> ans = groupMapper.selectByExample(example);
        if(ans.size() == 0)return null;
        else return ans.get(0);
    }



}
