package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private List<CourseEnrollmentDto> courses;

    public StudentDto(long id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }
}
