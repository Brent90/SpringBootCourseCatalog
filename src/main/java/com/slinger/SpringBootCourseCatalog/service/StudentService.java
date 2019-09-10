package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Student;

public interface StudentService {

    public Student getStudentById(int id);

    public void saveStudent(Student student);

}
