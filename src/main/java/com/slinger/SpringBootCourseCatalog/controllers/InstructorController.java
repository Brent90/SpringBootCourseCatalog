package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.InstructorDetail;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private CourseService courseService;

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }



    @RequestMapping("/listInstructors")
    public String getAllInstructors(Model model) {
        List<Instructor> instructors = instructorService.getInstructors();
        model.addAttribute("instructors", instructors);
        return "instructor-pages/list-all-instructors";
    }



    @RequestMapping("/instructorDetails")
    public String getInstructorDetail(@RequestParam("courseId") int id, Model model) {
        Course course = courseService.getCourseById(id);



        Instructor instructors = course.getInstructor();

        if(instructors == null) {
            return "instructor-pages/no-instructor-found";
        }


        model.addAttribute("instructors", instructors);
        return "instructor-pages/list-detail-update";
    }


    @RequestMapping("/fullInstructorDetails")
    public String getAllInstructorDetail(@RequestParam("instructorId") int id, Model model) {

        Instructor instructor = instructorService.getInstructorById(id);

        System.out.println(instructor);

        model.addAttribute("instructor", instructor);
        return "instructor-pages/instructor-detail";
    }






}
