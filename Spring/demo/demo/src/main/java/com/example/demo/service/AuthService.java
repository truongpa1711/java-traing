package com.example.demo.service;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RefeshTokenRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    public AuthService(StudentRepository studentRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils,
                       AuthenticationManager authenticationManager) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public BaseResponseDTO<?> login(LoginRequest loginRequest) {
        try {
            Student student = studentRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new Exception("User not found"));

            if (!passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
                return errorResponse("Invalid password");
            }

            Set<String> roleNames = extractRoleNames(student);
            String accessToken = jwtUtils.generateAccessToken(student.getId(), student.getUsername(), roleNames);

            LoginResponse response = buildLoginResponse(student, accessToken, null, roleNames);
            return successResponse("Login successful", response);

        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }

    public BaseResponseDTO<?> login_v2(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            if (!authentication.isAuthenticated()) {
                return errorResponse("Invalid credentials");
            }

            Student student = studentRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new Exception("User not found"));

            Set<String> roleNames = extractRoleNames(student);
            String accessToken = jwtUtils.generateAccessToken(student.getId(), student.getUsername(), roleNames);
            String refreshToken = jwtUtils.generateRefreshToken(authentication);

            LoginResponse response = buildLoginResponse(student, accessToken, refreshToken, roleNames);
            return successResponse("Login successful", response);

        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }

    public BaseResponseDTO<?> refreshToken(RefeshTokenRequest refeshTokenRequest) {
        try {
            String refreshToken = refeshTokenRequest.getRefreshToken();
            if (!jwtUtils.validateRefreshToken(refreshToken)) {
                return errorResponse("Invalid or expired refresh token");
            }

            String username = jwtUtils.extractUsername(refreshToken);
            Student student = studentRepository.findByUsername(username)
                    .orElseThrow(() -> new Exception("User not found"));

            Set<String> roleNames = extractRoleNames(student);
            String newAccessToken = jwtUtils.generateAccessToken(student.getId(), student.getUsername(), roleNames);

            String newRefreshToken = jwtUtils.generateRefreshToken(
                    new UsernamePasswordAuthenticationToken(
                            student.getUsername(),
                            null
                    )
            );
            LoginResponse response = buildLoginResponse(student, newAccessToken, newRefreshToken, roleNames);
            return successResponse("Token refreshed successfully", response);

        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }

    private Set<String> extractRoleNames(Student student) {
        return student.getRoles().stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
    }

    private LoginResponse buildLoginResponse(Student student, String accessToken, String refreshToken, Set<String> roles) {
        LoginResponse response = new LoginResponse();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setUsername(student.getUsername());
        response.setRoles(roles);
        return response;
    }

    private BaseResponseDTO<?> successResponse(String message, Object data) {
        return BaseResponseDTO.builder()
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    private BaseResponseDTO<?> errorResponse(String message) {
        return BaseResponseDTO.builder()
                .status("error")
                .message(message)
                .data(null)
                .build();
    }
}
