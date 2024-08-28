// ScheduleController.java
package com.sparta.gwajea.controller;

import com.sparta.gwajea.dto.CommentRequestDto;
import com.sparta.gwajea.dto.ScheduleRequestDto;
import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }
}
