package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponseDTO<T> {
    private String status;
    private String message;
    private T data;
}
