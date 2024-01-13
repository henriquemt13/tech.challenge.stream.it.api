package com.tech.challenge.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VideoResponseDTO {

    private Long id;
    private Long uploaderUserId;
    private String videoName;
    private String videoDescription;
    private String videoPath;
    private LocalDateTime uploadDate;
}
