package com.tech.challenge.entity;

import com.tech.challenge.model.LikeOptionEnum;
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
@Table(name = "like_table")
public class LikeEntity {

    @Id
    @SequenceGenerator(name = "like_table_seq",
            sequenceName = "like_table_seq", allocationSize = 1)
    @GeneratedValue(generator = "like_table_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "video_id", unique = true)
    @NotNull(message = "videoId should not be null")
    private Long videoId;
    @Column(name = "user_id", unique = true)
    @NotNull(message = "userId should not be null")
    private Long userId;
    @Column(name = "like_option", unique = true)
    @NotNull(message = "likeOption should not be null")
    @NotEmpty(message = "likeOption should not be empty")
    private LikeOptionEnum likeOption;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LikeEntity(Long videoId, Long userId, LikeOptionEnum likeOption) {
        this.videoId = videoId;
        this.userId = userId;
        this.likeOption = likeOption;
    }
}
