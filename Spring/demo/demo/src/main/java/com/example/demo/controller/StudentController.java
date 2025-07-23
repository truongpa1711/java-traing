package com.example.demo.controller;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    //api tra ve pageable tu config
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<BaseResponseDTO<?>> getAllStudents(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(defaultValue = "username") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Page<Student> studentsPage = studentService.getAllStudents(page, size, keyword, sortBy, direction);
        List<StudentDto> studentDtos = studentsPage.getContent().stream()
                .map(studentMapper::studentToStudentDto)
                .collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("students", studentDtos);
        result.put("currentPage", studentsPage.getNumber() + 1);
        result.put("totalItems", studentsPage.getTotalElements());
        result.put("totalPages", studentsPage.getTotalPages());

        return ResponseEntity.ok(
                BaseResponseDTO.builder()
                        .status("success")
                        .message("Students retrieved successfully")
                        .data(result)
                        .build()
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all_v1")
    public ResponseEntity<BaseResponseDTO<?>> getAllStudents_v1(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(defaultValue = "username") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        try {
            Page<StudentDto> studentsPage = studentService.getAllStudents_v1(page, size, keyword, sortBy, direction);
            return ResponseEntity.ok(
                    BaseResponseDTO.builder()
                            .status("success")
                            .message("Students retrieved successfully")
                            .data(studentsPage)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    BaseResponseDTO.builder()
                            .status("error")
                            .message("An error occurred while retrieving students: " + e.getMessage())
                            .data(null)
                            .build()
            );
        }
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
