package com.tech.challenge.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchVideoDTO {

    private String videoName;
    private LocalDateTime uploadDate;
    private Integer page;
    private Integer size;
}
