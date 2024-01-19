package com.tech.challenge.mapper;

import com.tech.challenge.dto.MetricsDTO;
import com.tech.challenge.dto.response.MetricsResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetricsMapper extends
        ResponseMapper<MetricsDTO, MetricsResponseDTO> {
}
