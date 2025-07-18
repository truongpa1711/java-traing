package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lazy-loading")
public class LazyLoading {
    private final StudentRepository studentRepository ;
    public LazyLoading(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/example")
    public String example() {
        List<Student> students= studentRepository.findAll();
        for (Student student : students) {
            // Accessing the lazy-loaded collection
            System.out.println("Student Name: " + student.getName());
            // This will trigger the lazy loading of studentCourses
            System.out.println("Courses: " + student.getStudentCourses().size());
        }
        return "Lazy loading example endpoint";
    }
}
