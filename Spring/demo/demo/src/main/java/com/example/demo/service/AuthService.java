package com.example.demo.service;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RefeshTokenRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.entity.ERole;
import com.example.demo.entity.Role;
import com.example.demo.entity.Student;
import com.example.demo.event.StudentRegistrationEvent;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utils.JwtUtils;
import org.springframework.context.ApplicationEventPublisher;
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
    private final ApplicationEventPublisher applicationEventPublisher;

    public AuthService(StudentRepository studentRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils,
                       AuthenticationManager authenticationManager, ApplicationEventPublisher applicationEventPublisher) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.applicationEventPublisher = applicationEventPublisher;
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

    public BaseResponseDTO<?> register(RegisterRequest registerRequest) {
        try{
            if(studentRepository.existsByUsername(registerRequest.getUsername())) {
                return errorResponse("Username already exists");
            }
            if(studentRepository.existsByEmail(registerRequest.getEmail())) {
                return errorResponse("Email already exists");
            }
            Role defaultRole = new Role();
            defaultRole.setId(1L);
            defaultRole.setName(ERole.STUDENT);

            String verificationToken = jwtUtils.generateVerificationToken(registerRequest.getEmail());

            Student student = Student.builder()
                    .name(registerRequest.getName())
                    .email(registerRequest.getEmail())
                    .username(registerRequest.getUsername())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .roles(Set.of(defaultRole)) // Default role
                    .is_verified(false)
                    .verification_token(verificationToken)// Assuming new users are enabled by default
                    .build();
            studentRepository.save(student);
            applicationEventPublisher.publishEvent(new StudentRegistrationEvent(this, student));
            return successResponse("Registration successful", student);
        }catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }

    public BaseResponseDTO<?> verifyEmail(String token) {
        try {
            if (!jwtUtils.validateVerificationToken(token)) {
                return errorResponse("Invalid or expired verification token");
            }
            String email = jwtUtils.extractEmailFromVerificationToken(token);
            Student student = studentRepository.findByEmail(email)
                    .orElseThrow(() -> new Exception("User not found"));

            if (student.is_verified()) {
                return errorResponse("Email already verified");
            }

            student.set_verified(true);
            student.setVerification_token(null); // Clear the verification token
            studentRepository.save(student);

            return successResponse("Email verified successfully", student);
        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }

    //======================

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
