package com.example.demo.controller;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.iml.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IAuthService authService;
    private final StudentRepository studentRepository;

    public AuthController(IAuthService authService, StudentRepository studentRepository) {
        this.authService = authService;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/login")
    public BaseResponseDTO<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        return authService.login(loginRequest);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        List<?> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return ResponseEntity.ok("No students found");
        }
        return ResponseEntity.ok(students);
    }
}
