package com.tech.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultDTO<T> {

    private List<T> response;
    private Integer totalPages;
    private Long totalElements;
    private Integer page;
    private Integer elementsPerPage;

}