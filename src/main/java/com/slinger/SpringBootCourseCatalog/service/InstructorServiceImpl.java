package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.findByOrderByLastNameAsc();
    }

    @Override
    public void createInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }




//    @Override
//    public void addCourse(Instructor instructor, Course course) {
//        instructor.addCourse(course);
//        instructorRepository.save(instructor);
//    }




}
