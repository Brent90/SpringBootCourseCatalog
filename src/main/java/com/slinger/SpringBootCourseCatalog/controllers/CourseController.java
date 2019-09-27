package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.Student;
import com.slinger.SpringBootCourseCatalog.pojos.Department;
import com.slinger.SpringBootCourseCatalog.service.CourseService;
import com.slinger.SpringBootCourseCatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private StudentService studentService;


    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/listCourses")
    public String getAllCourse(Model model) {
        List<Course> courses = courseService.getAllCourses();
        Instructor emptyInstructor = new Instructor();

        //prevents null pointer from being thrown when trying to display a course with no instructor
        for(Course c : courses) {
            if(c.getInstructor() == null) {
                c.setInstructor(emptyInstructor);
            }
        }

        //get current student
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.findStudentByEmail(authUser.getUsername());
        model.addAttribute("student", student);

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



//    @RequestMapping("/searchByDepartment")
//    public String searchByDepartment(@ModelAttribute("department") Department selected, Model model) {
//        String department = selected.getDepartment();
//
//        if(department.equals("All")) {
//            List<Course> courses = courseService.getAllCourses();
//            model.addAttribute("courses", courses);
//            return "course-pages/list-all-courses";
//        }
//
//
//        List<Course> courses = courseService.getCoursesByDepartment(department);
//        model.addAttribute("courses", courses);
//
//
//        return "course-pages/list-all-courses";
//    }



    @RequestMapping("/searchByDepartment")
    public String searchByDepartment(@ModelAttribute("department") Department selected, Model model) {
       // String department = selected.getDepartment();

        String department = selected.getDepartment();

        System.out.println(department);

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




//    @RequestMapping("/courseInstructors")
//    public List<Instructor>  getCourseInstructors(@RequestParam("courseId") int id, Model model) {
//        List<Instructor> instructors;
//        Course course = courseService.getCourseById(id);
//        instructors = course.getInstructors();
//        return instructors;
//    }




}
