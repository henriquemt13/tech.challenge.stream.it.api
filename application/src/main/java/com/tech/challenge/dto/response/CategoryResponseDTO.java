package com.tech.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
