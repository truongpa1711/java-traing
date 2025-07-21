package com.example.demo.event;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StudentRegistrationListener {
    @Autowired
    private JavaMailSender mailSender;

    @EventListener
    @Async
    public void handleUserRegistrationEvent(StudentRegistrationEvent event) {
        Student student = event.getStudent();
        String verificationLink = "http://localhost:8080/auth/verify?token=" + student.getVerification_token();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(student.getEmail());
        message.setSubject("Xác thực email đăng ký");
        message.setText("Chào " + student.getName() + ",\n\n"
                + "Vui lòng nhấn vào liên kết sau để xác thực tài khoản: \n"
                + verificationLink + "\n\n"
                + "Liên kết này sẽ hết hạn sau 5 phut.");
        message.setFrom("littlefox171103@gmail.com");
        mailSender.send(message);
    }
}