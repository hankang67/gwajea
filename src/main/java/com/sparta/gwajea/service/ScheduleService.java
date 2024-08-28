package com.sparta.gwajea.service;

import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> getSchedule(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule updateSchedule(Long id, Schedule updatedSchedule) {
        return scheduleRepository.findById(id).map(schedule -> {
            schedule.setTitle(updatedSchedule.getTitle());
            schedule.setDescription(updatedSchedule.getDescription());
            return scheduleRepository.save(schedule);
        }).orElseThrow(() -> new IllegalArgumentException("Schedule not found"));
    }
}
