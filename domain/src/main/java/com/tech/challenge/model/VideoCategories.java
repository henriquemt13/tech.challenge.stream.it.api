package com.tech.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoCategories {

    private Long id;
    private Long videoId;
    private Long categoryId;
    private LocalDateTime createdAt;
}
