package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.InstructorDetail;
import com.slinger.SpringBootCourseCatalog.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @RequestMapping("/listInstructors")
    public String getAllInstructors(Model model) {
        List<Instructor> instructors = instructorService.getInstructors();
        model.addAttribute("instructors", instructors);
        return "list-all-instructors";
    }

    @RequestMapping("/instructorDetails")
    public String getInstructorDetail(@RequestParam("instructorId") int id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        InstructorDetail detail = instructor.getInstructorDetail();

        model.addAttribute("instructor", instructor);
        model.addAttribute("instructorDetails", detail);

        return "instructor-detail-page";
    }

}
