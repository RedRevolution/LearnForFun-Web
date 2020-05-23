package com.buaa.learnforfun.service;

import com.buaa.learnforfun.dao.TimetableMapper;
import com.buaa.learnforfun.entity.Timetable;
import com.buaa.learnforfun.entity.TimetableExample;
import com.buaa.learnforfun.service.mapper.TimetableMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    @Autowired
    TimetableMapper timetableMapper;
    @Autowired
    TimetableMapperService timetableMapperService;

    public Timetable create(Timetable timetable) {
        timetableMapper.insertSelective(timetable);
        return timetable;
    }

    public List<Timetable> findTimetable(String userId) {
        Timetable timetable = new Timetable();
        timetable.setUserId(userId);
        return timetableMapperService.find(timetable);
    }

    public String deleteTimetable(long id) {
        timetableMapper.deleteByPrimaryKey(id);
        return "success";
    }

    public String modifyTimetable(Timetable timetable) {
        timetableMapper.updateByPrimaryKeySelective(timetable);
        return "success";
    }

}
