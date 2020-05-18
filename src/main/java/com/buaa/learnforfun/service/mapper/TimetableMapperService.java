package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.TimetableMapper;
import com.buaa.learnforfun.entity.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableMapperService {
    @Autowired
    TimetableMapper timetableMapper;

}
