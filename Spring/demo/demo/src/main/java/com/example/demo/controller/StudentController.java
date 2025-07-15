package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(
                studentService.getAllStudents().stream()
                        .map(student -> studentMapper.studentToStudentDto((Student) student))
                        .collect(Collectors.toList())
        );
    }
    @PostMapping("/enroll")
    public String enrollStudentInCourse(@RequestBody Map<String, Long> payload) {
        Long studentId = payload.get("studentId");
        Long courseId = payload.get("courseId");

        System.out.println("Received request to enroll student with ID: " + studentId + " in course with ID: " + courseId);

        boolean enrolled = studentService.enrollStudentInCourse(studentId, courseId);
        return enrolled ? "Student enrolled successfully." : "Enrollment failed. Student or course not found.";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDto> getStudentWithCourses(@PathVariable Long id) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//
//        StudentDto dto = studentService.convertToDto(student);
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentWithCourses(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudentDto dto = studentMapper.studentToStudentDto(student);
        return ResponseEntity.ok(dto);
    }

}
