package com.tech.challenge.model;

import com.tech.challenge.dto.CreateVideoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Long id;
    private String videoName;
    private String videoDescription;
    private Long uploaderUserId;
    private LocalDateTime uploadDate;
    private byte[] videoFile;

    public Video(CreateVideoDTO createVideoDTO) throws IOException {
        this.videoName = createVideoDTO.getVideoName();
        this.videoDescription = createVideoDTO.getVideoDescription();
        this.uploaderUserId = createVideoDTO.getUserId();
        this.uploadDate = LocalDateTime.now();
        this.videoFile = createVideoDTO.getVideo().getBytes();
    }
}
