package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;

import java.util.List;

public interface InstructorService {

    public List<Instructor> getInstructors();

    public void createInstructor(Instructor instructor);

    public Instructor getInstructorById(int id);

//    public void addCourse(Instructor instructor, Course course);


}
