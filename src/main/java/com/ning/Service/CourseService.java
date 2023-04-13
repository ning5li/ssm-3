package com.ning.Service;

import com.ning.bean.Course;

import java.util.List;

public interface CourseService {

    List<Course> allCourses();//查询所有课程 并排序

    Course selectCourse(Integer id);

    Integer addCourse(Course course);//新增课程

    Integer updateCourse(Course course);

    Integer deleteCourse(Integer id);

    Course selectByName(String name);
}
