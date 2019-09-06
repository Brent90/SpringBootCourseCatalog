package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.InstructorDetail;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InstructorCRUD {

    //THIS CLASS IS FOR TESTING ONLY

    private InstructorService instructorService;

    @Autowired
    public InstructorCRUD(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @RequestMapping("/create")
    public void createInstructor() {
//        Instructor instructor = new Instructor("Maximilian", "Rosario", "Biology");
//        instructorService.createInstructor(instructor);
    }

    @RequestMapping("/detail")
    public void addInstructorDetail() {
//        Instructor instructor = instructorService.getInstructorById(3);
//        InstructorDetail detail = new InstructorDetail("Professor of Chemistry ", "444-5555", "email@gmail", "999 Everett Tower, Mail Stop 345", "bio goes here");
//        instructor.setInstructorDetail(detail);
//        instructorService.createInstructor(instructor);

    }

    @RequestMapping("/createCourse")
    public void createCourse() {
//        Course course = new Course("CHM300", "Organic Chemistry 1", "course description here", "4", "Chemistry");
//        Instructor instructor = instructorService.getInstructorById(3);
//
//        instructor.addCourse(course);
//        instructorService.createInstructor(instructor);

    }


}
