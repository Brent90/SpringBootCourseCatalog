package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.repository.CourseRepository;

import java.util.List;

public interface CourseService  {

    public List<Course> getAllCourses();

    public Course getCourseById(int id);

    public List<Course> getCoursesByDepartment(String department);

    public void createCourse(Course course);




}
