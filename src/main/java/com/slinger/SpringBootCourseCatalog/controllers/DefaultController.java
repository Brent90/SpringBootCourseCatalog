package com.slinger.SpringBootCourseCatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

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
    public String showStudentHomePage() {
        return "student-pages/student-home-page";
    }

    @RequestMapping("/instructor")
    public String showInstructorHomePage() {
        return "instructor-pages/instructor-home-page";
    }




}
