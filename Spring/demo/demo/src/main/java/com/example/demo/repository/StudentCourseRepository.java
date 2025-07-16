package com.example.demo.repository;

import com.example.demo.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    // Custom query methods can be defined here if needed
}
