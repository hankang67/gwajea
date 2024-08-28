package com.sparta.gwajea.controller;

import com.sparta.gwajea.entity.Comment;
import com.sparta.gwajea.entity.Schedule;
import com.sparta.gwajea.service.CommentService;
import com.sparta.gwajea.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final ScheduleService scheduleService;

    @PostMapping("/create")
    public String createComment(@RequestParam Long scheduleId, @ModelAttribute Comment comment) {
        Schedule schedule = scheduleService.getSchedule(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));
        comment.setSchedule(schedule);
        commentService.saveComment(comment);
        return "redirect:/schedules/" + scheduleId;
    }

    @GetMapping("/{id}")
    public String getComment(@PathVariable Long id, Model model) {
        Comment comment = commentService.getComment(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        model.addAttribute("comment", comment);
        return "comment-detail";
    }

    @PostMapping("/{id}/update")
    public String updateComment(@PathVariable Long id, @ModelAttribute Comment comment) {
        Comment updatedComment = commentService.updateComment(id, comment);
        return "redirect:/comments/" + updatedComment.getId();
    }

    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "redirect:/schedules";
    }
}
