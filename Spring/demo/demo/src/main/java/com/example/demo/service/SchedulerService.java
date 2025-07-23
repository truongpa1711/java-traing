package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {
    @Scheduled(cron = "0 0 */6 * * *")
    public void scheduledTask() {
        // This method will be executed every 4 seconds
        System.out.println("Scheduled task executed at: " + java.time.LocalTime.now());
    }
}
