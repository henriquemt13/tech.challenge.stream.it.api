package com.tech.challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "video")
public class VideoEntity {

    @Id
    @SequenceGenerator(name = "video_seq",
            sequenceName = "video_seq", allocationSize = 1)
    @GeneratedValue(generator = "video_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "video_name", unique = true)
    @NotNull(message = "videoName should not be null")
    @NotEmpty(message = "videoName should not be empty")
    private String videoName;
    @Column(name = "video_description", unique = true)
    private String videoDescription;
    @Column(name = "video_path", unique = true)
    @NotNull(message = "videoPath should not be null")
    @NotEmpty(message = "videoPath should not be empty")
    private String videoPath;
    @Column(name = "uploader_user_id", unique = true)
    @NotNull(message = "uploaderUserId should not be null")
    private Long uploaderUserId;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime uploadDate;
}
