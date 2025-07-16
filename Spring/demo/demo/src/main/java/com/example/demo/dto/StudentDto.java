package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private List<CourseEnrollmentDto> courses;
}
