package com.slinger.SpringBootCourseCatalog.service;

import com.slinger.SpringBootCourseCatalog.entity.Student;
import com.slinger.SpringBootCourseCatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }


}
