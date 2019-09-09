package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("")
    public String adminHome() {
        return "admin-pages/admin-home";
    }


//    START OF CREATING NEW COURSE CODE

    @RequestMapping("/createCourse")
    public String showCreateCourseForm(Model model) {

        Course course = new Course();
        model.addAttribute("course", course);

        return "admin-pages/create-course";
    }

    @PostMapping("/processCreateCourseForm")
    public String processCreateCourseForm(@ModelAttribute("course") Course newCourse, Model model) {
        courseService.createCourse(newCourse);
        model.addAttribute("course", newCourse);

        return "admin-pages/create-course-success";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(@RequestParam("id") int id, Model model) {
        //get customer with given id
        Course course = courseService.getCourseById(id);
        //prepopulate form
        model.addAttribute("course", course);

        System.out.println("updated course " + course);

        return "admin-pages/create-course";

    }
    //    END OF CREATING NEW COURSE CODE



    //    START OF CREATING NEW INSTRUCTOR CODE
    @RequestMapping("/createInstructor")
    public String showCreateInstructorForm(Model model) {

        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);

        return "admin-pages/create-instructor";
    }

    @PostMapping("/processCreateInstructorForm")
    public String processCreateInstructorForm(@ModelAttribute("instructor") Instructor newInstructor, Model model) {
        instructorService.createInstructor(newInstructor);
        model.addAttribute("instructor", newInstructor);

        return "admin-pages/create-instructor-success";
    }

    @RequestMapping("/updateInstructor")
    public String updateInstructor(@RequestParam("id") int id, Model model) {
        //get instructor with given id
        Instructor instructor = instructorService.getInstructorById(id);
        //prepopulate form
        model.addAttribute("instructor", instructor);

        return "admin-pages/create-instructor";

    }
    //     END OF CREATING NEW INSTRUCTOR



}
