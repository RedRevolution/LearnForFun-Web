package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.UserCollectMapper;
import com.buaa.learnforfun.entity.UserCollect;
import com.buaa.learnforfun.entity.UserCollectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectMapperService {
    @Autowired
    UserCollectMapper userCollectMapper;

    public List<UserCollect> find(UserCollect template) {
        UserCollectExample example = new UserCollectExample();
        if (template.getUserId() != null) {
            example.or().andUserIdEqualTo(template.getUserId());
        }
        if (template.getShareId() != null) {
            example.or().andShareIdEqualTo(template.getShareId());
        }
        return userCollectMapper.selectByExample(example);
    }

    public void delete(UserCollect userCollect) {
        if (userCollect.getId() != null) {
            userCollectMapper.deleteByPrimaryKey(userCollect.getId());
        } else {
            List<UserCollect> temp = find(userCollect);
            for (UserCollect i : temp) {
                userCollectMapper.deleteByPrimaryKey(i.getId());
            }
        }
    }

}
