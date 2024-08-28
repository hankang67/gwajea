package com.sparta.gwajea.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String content;
    private String username;
    private Long scheduleId; // Comment와 연관된 Schedule ID를 받기 위함
}