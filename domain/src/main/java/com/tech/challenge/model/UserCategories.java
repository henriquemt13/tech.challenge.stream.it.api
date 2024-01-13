package com.tech.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserCategories {

    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime createdAt;

    public UserCategories(Long userId, Long categoryId) {
        this.userId = userId;
        this.categoryId = categoryId;
    }
}
