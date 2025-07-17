package com.example.demo.dto.response;

import com.example.demo.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private Set<String> roles;
}
