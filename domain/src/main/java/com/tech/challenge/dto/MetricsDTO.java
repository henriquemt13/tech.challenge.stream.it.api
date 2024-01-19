package com.tech.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsDTO {

    private Long totalVideos;
    private Long totalInteractions;
    private Long totalLikes;
    private Long totalViews;
}
