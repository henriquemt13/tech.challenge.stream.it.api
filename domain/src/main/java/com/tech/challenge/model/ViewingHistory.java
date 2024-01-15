package com.tech.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewingHistory {

    private Long id;
    private Long userId;
    private Long videoId;
    private LocalDateTime createdAt;
}
