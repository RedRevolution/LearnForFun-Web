package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.SelectCourseMapper;
import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.SelectCourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCourseMapperService {
    @Autowired
    SelectCourseMapper selectCourseMapper;

    public void add(SelectCourse selectCourse) {
        if (find(selectCourse).size() == 0)
            selectCourseMapper.insertSelective(selectCourse);
    }

    public List<SelectCourse> find(SelectCourse template) {
        SelectCourseExample example = new SelectCourseExample();
        SelectCourseExample.Criteria criteria = example.createCriteria();
        if (template.getStudentId() != null) {
            criteria.andStudentIdEqualTo(template.getStudentId());
        }
        if (template.getCourseId() != null) {
            criteria.andCourseIdEqualTo(template.getCourseId());
        }
        return selectCourseMapper.selectByExample(example);
    }

}
