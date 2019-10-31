package com.slinger.SpringBootCourseCatalog.controllers;

import com.slinger.SpringBootCourseCatalog.entity.*;
import com.slinger.SpringBootCourseCatalog.pojos.IDHolder;
import com.slinger.SpringBootCourseCatalog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;




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
//        instructorService.createInstructor(newInstructor);
//        model.addAttribute("instructor", newInstructor);
//
//        return "admin-pages/create-instructor-success";

        String username = newInstructor.getFirstName();

//        studentService.saveStudent(student);

        String password = "{noop}password";
        User user = new User(username, password, 1);
        user.setAuthorities(new Authorities(username, "ROLE_INSTRUCTOR"));


        try {

            //check if user is already in database
            try {
                userService.save(user);
            } catch (Exception ex) {
                //fix this later to make it user friendly
                throw new RuntimeException("user already created");
            }

            instructorService.createInstructor(newInstructor);

            return "admin-pages/create-instructor-success";
        }catch(DataIntegrityViolationException e) {
            //catch the duplicate to prevent spring from throwing exception and return to success page to edit
            return "admin-pages/create-instructor-success";
        }







    }

    @RequestMapping("/updateInstructor")
    public String updateInstructor(@RequestParam("id") int id, Model model) {
        //get instructor with given id
        Instructor instructor = instructorService.getInstructorById(id);
        //prepopulate form
        model.addAttribute("instructor", instructor);

        return "admin-pages/create-instructor";

    }
    //     END OF CREATING NEW INSTRUCTOR CODE


    //  START OF ADDING INSTRUCTOR TO COURSE CODE
    @RequestMapping("/linkInstructorToCourse")
    public String showFormToLinkInstructorToCourse(Model model) {
        IDHolder id_Holder = new IDHolder();
        model.addAttribute("id_Holder", id_Holder);

        return "admin-pages/link-course-and-instructor";
    }

    @PostMapping("/processInstructorToCourse")
    public String processInstructorToCourse(@ModelAttribute("id_Holder") IDHolder holder) {
        int courseId = holder.getCourseId();
        int instructorId = holder.getInstructorId();

        Course course = courseService.getCourseById(courseId);
        Instructor instructor = instructorService.getInstructorById(instructorId);

        course.setInstructor(instructor);
        courseService.createCourse(course);
        instructorService.createInstructor(instructor);


        return "admin-pages/admin-home-page";
    }

    // END OF ADDING INSTRUCTOR TO COURSE CODE


    //  START OF ADDING A STUDENT CODE
    @RequestMapping("createStudent")
    public String createStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "admin-pages/create-student";
    }

    @PostMapping("processCreateStudentForm")
    public String processCreateStudentForm(@ModelAttribute("student") Student student) {
        String username = student.getEmail();

//        studentService.saveStudent(student);

        String password = "{noop}password";
        User user = new User(username, password, 1);
        user.setAuthorities(new Authorities(username, "ROLE_STUDENT"));


      try {

          //check if user is already in database
          try {
              userService.save(user);
          } catch (Exception ex) {
              //fix this later to make it user friendly
              throw new RuntimeException("user already created");
          }

          studentService.saveStudent(student);

          return "admin-pages/create-student-success";
      }catch(DataIntegrityViolationException e) {
          //catch the duplicate to prevent spring from throwing exception and return to success page to edit
          return "admin-pages/create-student-success";
      }



    }

    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") int id, Model model) {
        //get student with given id
        Student student = studentService.getStudentById(id);
            //prepopulate form
        model.addAttribute("student", student);

        return "admin-pages/create-student";

    }

}
