package com.slinger.SpringBootCourseCatalog.repository;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("Select c from Course c where c.department like %:department%")
    List<Course> findByPlaceContaining(String department);

    List<Course> findByOrderByDepartmentAsc();





}
