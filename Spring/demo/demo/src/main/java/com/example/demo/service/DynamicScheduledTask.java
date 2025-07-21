package com.example.demo.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
public class DynamicScheduledTask {
    private final TaskScheduler taskScheduler;

    private ScheduledFuture<?> scheduledFuture;

    public DynamicScheduledTask(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void StartTask(String cronExpression){
        stop();
        CronTrigger cronTrigger = new CronTrigger(cronExpression);
        scheduledFuture = taskScheduler.schedule(() -> {
            // Task logic goes here
            System.out.println("Dynamic scheduled task executed at: " + java.time.LocalTime.now());
        }, cronTrigger);

    }

    private void stop() {
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(true);
        }
    }
}
