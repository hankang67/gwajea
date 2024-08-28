package com.sparta.gwajea.controller;

import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable Long id, Model model) {
        Schedule schedule = scheduleService.getSchedule(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));
        model.addAttribute("schedule", schedule);
        return "schedule-detail";
    }

    @PostMapping
    public String createSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.saveSchedule(schedule);
        return "redirect:/schedules/" + schedule.getId();
    }

    @PostMapping("/{id}/update")
    public String updateSchedule(@PathVariable Long id, @ModelAttribute Schedule schedule) {
        scheduleService.updateSchedule(id, schedule);
        return "redirect:/schedules/" + id;
    }
}