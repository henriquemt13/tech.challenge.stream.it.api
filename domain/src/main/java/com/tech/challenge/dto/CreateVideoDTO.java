package com.tech.challenge.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateVideoDTO {

    private MultipartFile video;
    private List<Long> categoryIds;
    private String videoName;
    private String videoDescription;
    private Long userId;
}
