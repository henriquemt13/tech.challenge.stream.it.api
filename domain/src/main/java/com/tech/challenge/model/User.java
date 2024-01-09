package com.tech.challenge.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;
    private String username;
    private LocalDateTime createdAt;
}
