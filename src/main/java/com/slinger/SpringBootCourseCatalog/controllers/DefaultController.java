package com.slinger.SpringBootCourseCatalog.controllers;
import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Student;
import com.slinger.SpringBootCourseCatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String showTestPage() {
        return "public-landing-page";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home-page";
    }


    @RequestMapping("/admin")
    public String adminHome() {
        return "admin-pages/admin-home-page";
    }

    @RequestMapping("/student")
    public String showStudentHomePage(Model model) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = studentService.findStudentByEmail(authUser.getUsername());
        model.addAttribute("student", student);

        List<Course> courses = student.getCourses();
        model.addAttribute("courses", courses);

        return "student-pages/student-home-page";
    }

    @RequestMapping("/instructor")
    public String showInstructorHomePage() {
        return "instructor-pages/instructor-home-page";
    }




}
