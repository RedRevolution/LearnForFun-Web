package com.buaa.learnforfun.dao;

import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.CourseExample;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}