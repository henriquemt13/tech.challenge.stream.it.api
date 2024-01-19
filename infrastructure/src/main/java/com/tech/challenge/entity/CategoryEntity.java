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
@Table(name = "category")
public class CategoryEntity {

    @Id
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(generator = "category_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "name", unique = true)
    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be empty")
    private String name;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
