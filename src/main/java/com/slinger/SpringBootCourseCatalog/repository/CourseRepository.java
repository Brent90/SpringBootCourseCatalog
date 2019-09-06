package com.slinger.SpringBootCourseCatalog.repository;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {



}
