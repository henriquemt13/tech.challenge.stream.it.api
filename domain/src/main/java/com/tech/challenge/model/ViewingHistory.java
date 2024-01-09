package com.tech.challenge.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewingHistory {

    private Long id;
    private Long userId;
    private Long videoId;
    private LocalDateTime createdAt;
}
