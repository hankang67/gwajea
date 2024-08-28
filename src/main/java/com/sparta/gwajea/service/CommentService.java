package com.sparta.gwajea.service;

import com.sparta.gwajea.dto.CommentRequestDto;
import com.sparta.gwajea.entity.Comment;
import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.repository.CommentRepository;
import com.sparta.gwajea.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Comment createComment(CommentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));

        Comment comment = new Comment();
        comment.setContent(requestDto.getContent());
        comment.setUsername(requestDto.getUsername());
        comment.setSchedule(schedule);

        return commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
