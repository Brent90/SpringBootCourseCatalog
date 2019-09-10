package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.pojos.Department;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/listCourses")
    public String getAllCourse(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);



        return "course-pages/list-all-courses";
    }


    @RequestMapping("/courseDescription")
    public String getCourseDescription(@RequestParam("courseId") int id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);

        if(course.getDescription().isEmpty()) {
            course.setDescription("Sorry no description available");
        }

        return "course-pages/course-description";
    }



    @RequestMapping("/searchByDepartment")
    public String searchByDepartment(@ModelAttribute("department") Department selected, Model model) {
        String department = selected.getDepartment();

        if(department.equals("All")) {
            List<Course> courses = courseService.getAllCourses();
            model.addAttribute("courses", courses);
            return "course-pages/list-all-courses";
        }


        List<Course> courses = courseService.getCoursesByDepartment(department);
        model.addAttribute("courses", courses);

        return "course-pages/list-all-courses";
    }

    @ModelAttribute("departmentChoices")
    public List<Department> getDepartments(Model model) {
        List<Department> departmentList = new ArrayList<>();

        departmentList.add(new Department("All"));
        departmentList.add(new Department("Biology"));
        departmentList.add(new Department("Chemistry"));
        departmentList.add(new Department("Mathematics"));
        departmentList.add(new Department("Philosophy"));
        departmentList.add(new Department("Physics"));

        model.addAttribute("departments", departmentList);


        Department department = new Department();
        model.addAttribute("department", department);

        return departmentList;
    }


}
