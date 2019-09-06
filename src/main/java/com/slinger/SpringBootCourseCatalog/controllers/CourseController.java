package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("listCourses")
    public String getAllCourse(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "list-all-courses";
    }

}
