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
        selectCourseMapper.insertSelective(selectCourse);
    }

    public List<SelectCourse> find(SelectCourse template) {
        SelectCourseExample example = new SelectCourseExample();
        if (template.getStudentId() != null) {
            example.or().andStudentIdEqualTo(template.getStudentId());
        }
        if (template.getCourseCode() != null) {
            example.or().andCourseCodeEqualTo(template.getCourseCode());

        }
        if (template.getTeacherName() != null) {
            example.or().andTeacherNameEqualTo(template.getTeacherName());
        }
        return selectCourseMapper.selectByExample(example);
    }

}
