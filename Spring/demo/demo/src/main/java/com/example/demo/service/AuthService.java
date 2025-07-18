package com.example.demo.service;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }


    public BaseResponseDTO<?> login(LoginRequest loginRequest) throws Exception {
        try {
            Student student = studentRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new Exception("User not found"));
            System.out.println("Roles : " + student.getRoles());
            if (!passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
                return BaseResponseDTO.builder()
                        .status("error")
                        .message("Invalid password")
                        .data(null)
                        .build();
            }
            System.out.println("Roles: " + student.getRoles());
            Set<String> roleNames = student.getRoles().stream()
                    .map(role -> role.getName().name()) // Lấy tên Enum
                    .collect(Collectors.toSet());
            System.out.println("Role names: " + roleNames);

            String token = jwtUtils.generateToken(student.getId(), student.getUsername(), roleNames);


            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setUsername(student.getUsername());
            loginResponse.setRoles(roleNames);
            System.out.println("LoginResponse: " + loginResponse);
            return BaseResponseDTO.builder()
                    .status("success")
                    .message("Login successful")
                    .data(loginResponse)
                    .build();
        }
        catch (Exception e) {
            return BaseResponseDTO.builder()
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }

    //Login su dung AuthenticationManager
    public BaseResponseDTO<?> login_v2(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            if (authentication.isAuthenticated()) {
                Student student = studentRepository.findByUsername(loginRequest.getUsername())
                        .orElseThrow(() -> new Exception("User not found"));

                Set<String> roleNames = student.getRoles().stream()
                        .map(role -> role.getName().name()) // Lấy tên Enum
                        .collect(Collectors.toSet());

                String token = jwtUtils.generateToken(student.getId(), student.getUsername(), roleNames);

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setToken(token);
                loginResponse.setUsername(student.getUsername());
                loginResponse.setRoles(roleNames);

                return BaseResponseDTO.builder()
                        .status("success")
                        .message("Login successful")
                        .data(loginResponse)
                        .build();
            } else {
                return BaseResponseDTO.builder()
                        .status("error")
                        .message("Invalid credentials")
                        .data(null)
                        .build();
            }
        } catch (Exception e) {
            return BaseResponseDTO.builder()
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }
}
