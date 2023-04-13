package com.ning.Service.Impl;

import com.ning.Service.CourseService;
import com.ning.bean.Course;
import com.ning.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    //查询所有课程 并排序
    public List<Course> allCourses(){

       return  courseMapper.allCourses();
    }

    //根据id查询课程
    public Course selectCourse(Integer id){

        return courseMapper.selectCourse(id);

    }


    //新增课程
    public Integer addCourse(Course course) {

        return courseMapper.addCourse(course);

    }

    //更新课程信息
    public Integer updateCourse(Course course) {

        return courseMapper.updateCourse(course);


    }

    //根据id删除课程信息
    public Integer deleteCourse(Integer id) {

        return courseMapper.deleteCourse(id);


    }

    //根据课程名查找课程
    public Course selectByName(String name) {

        return courseMapper.selectByName(name);
    }
}
