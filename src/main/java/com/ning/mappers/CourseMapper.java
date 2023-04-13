package com.ning.mappers;

import com.ning.bean.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CourseMapper {


    List<Course> allCourses();//查询所有课程 并排序

    Course selectCourse(@Param("id") Integer id);

    Integer addCourse(Course course);//新增课程

    Integer updateCourse(Course course);

    Integer deleteCourse(@Param("id")Integer id);

    Course selectByName(String name);

}
