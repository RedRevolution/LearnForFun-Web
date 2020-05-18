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
        
        example.or().andCourseCodeEqualTo(template.getCourseCode()).andTeacherNameEqualTo(template.getTeacherName());
        //template.or().andCourseCodeEqualTo(template.getCourseCode());
        //template.or().andTeacherNameEqualTo(template.getTeacherName());
        List<Course> temp = courseMapper.selectByExample(example);
        return temp;
    }

    public void add(Course course) {
        courseMapper.insertSelective(course);
    }

}
