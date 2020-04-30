package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.SelectCourse;
import com.buaa.learnforfun.entity.SelectCourseExample;
import java.util.List;

public interface SelectCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectCourse record);

    int insertSelective(SelectCourse record);

    List<SelectCourse> selectByExample(SelectCourseExample example);

    SelectCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectCourse record);

    int updateByPrimaryKey(SelectCourse record);
}