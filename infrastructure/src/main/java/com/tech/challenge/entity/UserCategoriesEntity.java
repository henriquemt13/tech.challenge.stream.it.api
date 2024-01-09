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
@Table(name = "user_categories")
public class UserCategoriesEntity {

    @Id
    @SequenceGenerator(name = "user_categories_seq",
            sequenceName = "user_categories_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_categories_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "user_id", unique = true)
    @NotNull(message = "userId should not be null")
    private Long userId;
    @Column(name = "category_id", unique = true)
    @NotNull(message = "categoryId should not be null")
    private Long categoryId;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
