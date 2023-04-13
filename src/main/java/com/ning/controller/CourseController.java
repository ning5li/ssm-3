package com.ning.controller;

import com.ning.Service.Impl.CourseServiceImpl;
import com.ning.bean.Course;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;




    //课程列表
    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public String getAllCourses(Model model){

        List<Course> courses = courseService.allCourses();
        model.addAttribute("courses",courses);
        return "course_list";

    }

    //检查课程名是否重复
    @RequestMapping("/check")
    @ResponseBody
    public String validName(String name,Integer id){
        Course course = courseService.selectByName(name);
        if(course==null||(course!=null&&course.getId()==id)){
            return "false";
        }else{
            return "true";
        }

    }

//    添加课程
    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "course_add";
    }
    //添加课程
    @RequestMapping(value = "/course" ,method = RequestMethod.POST)
    public String courseAdd(Course course,HttpServletRequest request) throws IOException {
        Course courseByname = courseService.selectByName(course.getName());
        if(courseByname==null){
            courseService.addCourse(course);
        }
        return "redirect:/course";

    }

    //添加课程封面
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    private String fildUpload(Course course, @RequestParam(value="file",required=false) MultipartFile file,
                              HttpServletRequest request, HttpSession session)throws Exception{
        //未上传图片 默认
        if(file.getSize()==0){
            //把图片存储路径保存到数据库
            course.setImage("img/"+"默认.png");

            courseService.addCourse(course);
            //测试图片回显
            return "redirect:/course";

        }
        String sqlPath=null;//保存数据库的路径
        String filename=null;//定义文件名
        String contentType=file.getContentType();	//获取文件类型（后缀）
        //因为获取的后缀是XXXX/xxx形式
        contentType=contentType.substring(contentType.indexOf("/")+1);
        filename=course.getName()+"."+contentType;
        System.out.println(filename);
        String url = request.getSession().getServletContext().getRealPath("/img");
        System.out.println(url);
        url=url+"/";
        file.transferTo(new File(url+filename));//保存图片
        course.setImage("img/"+filename);

        courseService.addCourse(course);
        //测试图片回显
        return "redirect:/course";
    }



    //查询课程
    @RequestMapping(value = "/course/{id}",method = RequestMethod.GET)
    public String getCourseById(@PathVariable("id") Integer id, ModelMap model){

        Course course = courseService.selectCourse(id);
        model.addAttribute("change",course);
        return "course_update";

    }
    //更新课程信息
    @RequestMapping(value = "/course",method = RequestMethod.PUT)
    public String courseUpdate(@Param("course") Course course){
        courseService.updateCourse(course);
        return "redirect:/course";

    }
    //删除课程
    @RequestMapping(value = "/course/{id}",method = RequestMethod.DELETE)
    public String courseDelete(@PathVariable("id") Integer id){

        courseService.deleteCourse(id);
        return "redirect:/course";

    }

}
