package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.Student;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import com.slinger.SpringBootCourseCatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("addCourseToStudent")
    public String addCourse( @RequestParam("courseId") int courseId)  {
        //get current student logged in
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.findStudentByEmail(authUser.getUsername());

        try {

            //  Instructor instructorSelected = instructorService.getInstructorById(instructorId);
            Course courseSelected = courseService.getCourseById(courseId);

            student.addCourse(courseSelected);
            // courseSelected.addInstructor(instructorSelected);


            studentService.saveStudent(student);
        } catch (DataIntegrityViolationException e) {
                return "errors/course-already-added";
        }



        return "Course added";
    }




}
