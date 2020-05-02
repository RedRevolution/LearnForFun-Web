package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.Timetable;
import com.buaa.learnforfun.entity.TimetableExample;
import java.util.List;

public interface TimetableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    List<Timetable> selectByExample(TimetableExample example);

    Timetable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);
}