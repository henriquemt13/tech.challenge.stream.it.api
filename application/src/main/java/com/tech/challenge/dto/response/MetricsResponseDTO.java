package com.tech.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsResponseDTO {

    private Long totalVideos;
    private Long totalInteractions;
    private Long totalLikes;
    private Long totalViews;
}
