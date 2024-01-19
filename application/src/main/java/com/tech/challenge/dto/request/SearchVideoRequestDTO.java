package com.tech.challenge.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchVideoRequestDTO {

    private String videoName;
    private LocalDateTime uploadDate;
    private Integer page = 0;
    private Integer size = 1;
}
