package com.example.demo.event;

import com.example.demo.entity.Student;
import org.springframework.context.ApplicationEvent;

public class StudentRegistrationEvent extends ApplicationEvent {
    private final Student student;

    public StudentRegistrationEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}