package com.example.demo.controller;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RefeshTokenRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponseDTO<?>> login(@RequestBody LoginRequest loginRequest) {
        try {
            BaseResponseDTO<?> response = authService.login(loginRequest);
            if ("success".equals(response.getStatus())) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDTO.builder()
                            .status("error")
                            .message("Internal server error")
                            .data(null)
                            .build());
        }
    }

    @PostMapping("/login-v2")
    public ResponseEntity<BaseResponseDTO<?>> login_v2(@RequestBody LoginRequest loginRequest) {
        BaseResponseDTO<?> response = authService.login_v2(loginRequest);
        if ("success".equals(response.getStatus())) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<BaseResponseDTO<?>> refreshToken(@RequestBody RefeshTokenRequest refreshToken) {
        try {
            BaseResponseDTO<?> response = authService.refreshToken(refreshToken);
            if ("success".equals(response.getStatus())) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDTO.builder()
                            .status("error")
                            .message("Internal server error")
                            .data(null)
                            .build());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDTO<?>> register(@RequestBody RegisterRequest registerRequest) {
        try {
            BaseResponseDTO<?> response = authService.register(registerRequest);
            if ("success".equals(response.getStatus())) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // 400
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDTO.builder()
                            .status("error")
                            .message("Internal server error")
                            .data(null)
                            .build());
        }
    }
    @GetMapping("/verify")
    public ResponseEntity<BaseResponseDTO<?>> verifyEmail(@RequestParam("token") String token) {
        try {
            BaseResponseDTO<?> response = authService.verifyEmail(token);
            if ("success".equals(response.getStatus())) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // 400
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDTO.builder()
                            .status("error")
                            .message("Internal server error")
                            .data(null)
                            .build());
        }
    }
}
