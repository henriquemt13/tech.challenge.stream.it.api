package com.tech.challenge.mapper;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.dto.request.SearchVideoRequestDTO;
import com.tech.challenge.dto.response.VideoResponseDTO;
import com.tech.challenge.model.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoMapper extends
        ResponseMapper<Video, VideoResponseDTO>,
        CreateRequestMapper<SearchVideoDTO, SearchVideoRequestDTO> {


    CreateVideoDTO createRequestToDomain(CreateVideoRequestDTO createVideoRequestDTO, Long userId);
}
