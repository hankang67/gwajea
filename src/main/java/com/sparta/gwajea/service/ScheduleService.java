
package com.sparta.gwajea.service;

import com.sparta.gwajea.dto.CommentRequestDto;
import com.sparta.gwajea.dto.ScheduleRequestDto;
import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.repository.CommentRepository;
import com.sparta.gwajea.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setTitle(requestDto.getTitle());
        schedule.setDescription(requestDto.getDescription());
        schedule.setUsername(requestDto.getUsername());
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }
}
