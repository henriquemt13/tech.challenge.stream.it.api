package com.tech.challenge.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VideoCategories {

    private Long id;
    private Long videoId;
    private Long categoryId;
    private LocalDateTime createdAt;
}
