package com.tech.challenge.model;

import com.tech.challenge.dto.CreateVideoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Long id;
    private Long uploaderUserId;
    private String videoName;
    private String videoDescription;
    private String videoPath;
    private LocalDateTime uploadDate;

    public Video(CreateVideoDTO createVideoDTO) {
        this.videoName = createVideoDTO.getVideoName();
        this.videoDescription = createVideoDTO.getVideoDescription();
        this.uploaderUserId = createVideoDTO.getUserId();
        this.uploadDate = LocalDateTime.now();
    }
}
