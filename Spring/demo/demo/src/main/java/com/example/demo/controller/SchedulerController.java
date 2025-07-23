package com.example.demo.controller;

import com.example.demo.service.DynamicScheduledTask;
import com.example.demo.service.SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/scheduler")
@EnableScheduling
public class SchedulerController {
    private final SchedulerService schedulerService;
    private final DynamicScheduledTask dynamicScheduledTask;

    public SchedulerController(SchedulerService schedulerService, DynamicScheduledTask dynamicScheduledTask) {
        this.schedulerService = schedulerService;
        this.dynamicScheduledTask = dynamicScheduledTask;
    }

    @GetMapping("/start")
    public String startScheduler() {
        schedulerService.scheduledTask();
        return "Scheduler started. Check console for task execution logs.";
    }


    @PostMapping("/dynamic")
    public ResponseEntity<?> startDynamicScheduler(@RequestBody Map<String, String> body) {
        String cronExpression = body.get("cronExpression");
        if (!CronExpression.isValidExpression(cronExpression)) {
            return ResponseEntity.badRequest().body("Invalid cron expression");
        }
        dynamicScheduledTask.StartTask(cronExpression);
        return ResponseEntity.ok("Scheduler started with cron: " + cronExpression);
    }

}
