package com.tech.challenge.entity;

import jakarta.persistence.*;
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
@Table(name = "viewing_history")
public class ViewingHistoryEntity {

    @Id
    @SequenceGenerator(name = "viewing_history_seq",
            sequenceName = "viewing_history_seq", allocationSize = 1)
    @GeneratedValue(generator = "viewing_history_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "user_id", unique = true)
    @NotNull(message = "userId should not be null")
    private Long userId;
    @Column(name = "video_id", unique = true)
    @NotNull(message = "videoId should not be null")
    private Long videoId;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ViewingHistoryEntity(Long userId, Long videoId) {
        this.userId = userId;
        this.videoId = videoId;
    }
}
