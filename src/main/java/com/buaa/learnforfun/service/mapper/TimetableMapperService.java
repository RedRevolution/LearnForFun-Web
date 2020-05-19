package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.TimetableMapper;
import com.buaa.learnforfun.entity.Timetable;
import com.buaa.learnforfun.entity.TimetableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class TimetableMapperService {
    @Autowired
    TimetableMapper timetableMapper;

    public void add(Timetable timetable) {
        timetableMapper.insertSelective(timetable);
    }

    public List<Timetable> find(Timetable template) {
        TimetableExample example = new TimetableExample();
        if (template.getUserId() != null) {
            example.or().andUserIdEqualTo(template.getUserId());
        }
        return timetableMapper.selectByExample(example);
    }

    public void delete(Timetable timetable) {
        if (timetable.getId() != null) {
            timetableMapper.deleteByPrimaryKey(timetable.getId());
        } else {
            List<Timetable> temp = find(timetable);
            for (Timetable i : temp) {
                delete(i);
            }
        }
    }

}
