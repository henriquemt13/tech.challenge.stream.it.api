package com.tech.challenge.fixture;

import com.tech.challenge.dto.request.CreateVideoRequestDTO;

import java.util.List;

public class CreateVideoRequestDTOFixture {

    public CreateVideoRequestDTOFixture() {

    }

    public static CreateVideoRequestDTO newRequest() {
        CreateVideoRequestDTO requestDTO = new CreateVideoRequestDTO();
        requestDTO.setVideoName("test");
        requestDTO.setVideoDescription("test");
        requestDTO.setCategoryIds(List.of(1L));
        return requestDTO;
    }
}
