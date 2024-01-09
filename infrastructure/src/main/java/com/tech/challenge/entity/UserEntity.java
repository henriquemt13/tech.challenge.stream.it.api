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
@Table(name = "user")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_seq")
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "username", unique = true)
    @NotNull(message = "username should not be null")
    @NotEmpty(message = "username should not be empty")
    private String username;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
