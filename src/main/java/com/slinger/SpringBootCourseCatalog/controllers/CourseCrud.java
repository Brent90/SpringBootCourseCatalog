package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseCrud {

    //test purposes

    private CourseService courseService;
    private InstructorService instructorService;

    @Autowired(required = true)
    public CourseCrud(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping("/createCourse")
    public String createCourse() {
        Course course = new Course("MATH201", "Algebra 1", "course description here", "3", "Mathematics");

        courseService.createCourse(course);

        return "success";
    }

    @RequestMapping("/link")
    public String link() {
        //Instructor instructor = instructorService.getInstructorById(3);
        Course course = courseService.getCourseById(12);




        return "linked";
    }





}
