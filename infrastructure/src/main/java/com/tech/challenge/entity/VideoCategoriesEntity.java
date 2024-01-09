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
@Table(name = "video_categories")
public class VideoCategoriesEntity {

    @Id
    @SequenceGenerator(name = "video_categories_seq",
            sequenceName = "video_categories_seq", allocationSize = 1)
    @GeneratedValue(generator = "video_categories_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "video_id", unique = true)
    @NotNull(message = "videoId should not be null")
    private Long videoId;
    @Column(name = "category_id", unique = true)
    @NotNull(message = "categoryId should not be null")
    private Long categoryId;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
