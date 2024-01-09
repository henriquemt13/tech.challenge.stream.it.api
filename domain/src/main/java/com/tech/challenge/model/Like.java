package com.tech.challenge.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Like {

    private Long id;
    private Long videoId;
    private Long userId;
    private LikeOptionEnum likeOption;
    private LocalDateTime createdAt;
}
