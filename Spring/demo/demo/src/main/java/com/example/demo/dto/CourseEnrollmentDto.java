package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseEnrollmentDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate enrollmentDate;
}
