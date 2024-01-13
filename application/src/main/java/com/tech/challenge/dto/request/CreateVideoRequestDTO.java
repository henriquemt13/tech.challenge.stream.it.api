package com.tech.challenge.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateVideoRequestDTO {

    private MultipartFile video;
    private List<String> categories;
    private String videoName;
    private String videoDescription;
    private Long userId;
}
