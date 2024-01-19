package com.tech.challenge.fixture;

import com.tech.challenge.dto.MetricsDTO;
import com.tech.challenge.dto.response.MetricsResponseDTO;

public class MetricsResponseDTOFixture {
    public MetricsResponseDTOFixture() {
    }

    public static MetricsResponseDTO newMetricsResponseDTO() {
        return new MetricsResponseDTO(1L, 1L, 1L, 1L);
    }


    public static MetricsDTO newMetricsDTO() {
        return new MetricsDTO(1L, 1L, 1L, 1L);
    }
}
