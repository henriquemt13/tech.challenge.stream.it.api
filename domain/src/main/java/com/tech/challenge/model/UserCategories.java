package com.tech.challenge.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCategories {

    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime createdAt;
}
