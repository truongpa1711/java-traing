package com.example.demo.service.iml;

import com.example.demo.dto.BaseResponseDTO;
import com.example.demo.dto.request.LoginRequest;

public interface IAuthService {
    BaseResponseDTO<?> login(LoginRequest loginRequest) throws Exception;
}
