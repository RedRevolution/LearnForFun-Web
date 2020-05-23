package com.buaa.learnforfun.service.mapper;

import com.buaa.learnforfun.dao.CourseMapper;
import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.CourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMapperService {
    @Autowired
    CourseMapper courseMapper;

    public List<Course> find(Course template) {
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        if (template.getCourseId() != null) {
            criteria.andCourseIdEqualTo(template.getCourseId());
        }
        if (template.getCourseCode() != null) {
            criteria.andCourseCodeEqualTo(template.getCourseCode());
        }
        if (template.getCourseName() != null) {
            criteria.andCourseNameEqualTo(template.getCourseName());
        }
        if (template.getTeacherName() != null) {
            criteria.andTeacherNameEqualTo(template.getTeacherName());
        }
        if (template.getClassInfo() != null) {
            criteria.andClassInfoEqualTo(template.getClassInfo());
        }
        if (template.getGroupId() != null) {
            criteria.andGroupIdEqualTo(template.getGroupId());
        }
        List<Course> temp = courseMapper.selectByExample(example);
        return temp;
    }

    public void add(Course course) {
        courseMapper.insertSelective(course);
    }

}
