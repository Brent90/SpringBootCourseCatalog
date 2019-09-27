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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("addCourseToStudent")
    public String addCourse( @RequestParam("courseId") int courseId, Model model)  {
        //get current student logged in
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.findStudentByEmail(authUser.getUsername());

        try {
            Course courseSelected = courseService.getCourseById(courseId);
            model.addAttribute("course", courseSelected);

            if(courseSelected.getInstructor() == null) {
                Instructor emptyInstructor = new Instructor();
                courseSelected.setInstructor(emptyInstructor);
            }

            student.addCourse(courseSelected);
            studentService.saveStudent(student);

        } catch (DataIntegrityViolationException e) {
            return "errors/course-already-added";
        }



         return "course-pages/course-success-add";
    }




    @RequestMapping("dropCourse")
    public String dropCourse(@RequestParam("courseId") int courseId) {
        //get current student logged in
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.findStudentByEmail(authUser.getUsername());

        Course course = courseService.getCourseById(courseId);

        List<Student> students = course.getStudents();
        students.removeIf(s -> s.equals(student));

        courseService.createCourse(course);


        return "redirect:student";

    }


}
