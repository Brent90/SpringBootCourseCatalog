package com.slinger.SpringBootCourseCatalog.repository;

import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


}