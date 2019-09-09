package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.InstructorDetail;
import com.slinger.SpringBootCourseCatalog.repository.CourseRepository;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorCRUD {

    //THIS CLASS IS FOR TESTING ONLY

    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;

    @Autowired
    public InstructorCRUD(InstructorService instructorService) {
        this.instructorService = instructorService;
    }



    @RequestMapping("/create")
    public void createInstructor() {
        Instructor instructor = new Instructor("Maximilian", "Rosario", "Biology");
        Instructor instructor1 = new Instructor("Journey", "Flynn", "Physics");
        Instructor instructor2 = new Instructor("Sergio", "Carment", "Mathematics");
        Instructor instructor3 = new Instructor("Colby", "Lam", "Mathematics");
        Instructor instructor4 = new Instructor("Jamir", "Howard", "Chemistry");
        Instructor instructor5 = new Instructor("Rich", "Mcguire", "Chemistry");

        instructorService.createInstructor(instructor);
        instructorService.createInstructor(instructor1);
        instructorService.createInstructor(instructor2);
        instructorService.createInstructor(instructor3);
        instructorService.createInstructor(instructor4);
        instructorService.createInstructor(instructor5);


    }

    @RequestMapping("/detail")
    public void addInstructorDetail() {
        Instructor instructor = instructorService.getInstructorById(3);
        InstructorDetail detail = new InstructorDetail("Professor of Mathematics ", "444-5555", "email@gmail", "999 Everett Tower, Mail Stop 345", "bio goes here");
        instructor.setInstructorDetail(detail);
        instructorService.createInstructor(instructor);

        Instructor instructor2 = instructorService.getInstructorById(4);
        InstructorDetail detail2 = new InstructorDetail("Professor of Mathematics ", "675-2222", "email@gmail", "345 Everett Tower, Mail Stop 345", "bio goes here");
        instructor2.setInstructorDetail(detail2);
        instructorService.createInstructor(instructor2);


    }

    @RequestMapping("/addCourse")
    public String addCourse() {
//        Course course = courseService.getCourseById(12);
//        Instructor instructor = instructorService.getInstructorById(4);
//        instructor.addCourse(course);
//
//        System.out.println(course.getInstructors());
//
//        instructorService.createInstructor(instructor);

        return "success";
    }



}
