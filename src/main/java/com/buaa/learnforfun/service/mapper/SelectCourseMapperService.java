package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.SelectCourseMapper;
import com.buaa.learnforfun.entity.SelectCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectCourseMapperService {
    @Autowired
    SelectCourseMapper selectCourseMapper;

    public void add(SelectCourse selectCourse) {
        selectCourseMapper.insertSelective(selectCourse);
    }

}
