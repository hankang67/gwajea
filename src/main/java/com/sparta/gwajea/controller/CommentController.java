package com.sparta.gwajea.controller;

import com.sparta.gwajea.dto.CommentRequestDto;
import com.sparta.gwajea.entity.Comment;
import com.sparta.gwajea.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }
}