package com.sparta.gwajea.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    // Constructors, getters, and setters
}
