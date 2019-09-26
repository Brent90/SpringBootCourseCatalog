package com.slinger.SpringBootCourseCatalog.repository;

import com.slinger.SpringBootCourseCatalog.entity.Course;
import com.slinger.SpringBootCourseCatalog.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("Select c from Instructor c where c.firstName like %:fullName%")
    Instructor findByPlaceContaining(String fullName);

    List<Instructor> findByOrderByLastNameAsc();

}
