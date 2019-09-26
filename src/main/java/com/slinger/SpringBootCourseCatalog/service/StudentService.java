package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import com.slinger.SpringBootCourseCatalog.entity.Student;

public interface StudentService {

    public Student getStudentById(int id);

    public void saveStudent(Student student);

    public Student findStudentByEmail(String email);


}
