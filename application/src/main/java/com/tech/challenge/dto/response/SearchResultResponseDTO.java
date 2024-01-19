package com.tech.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultResponseDTO<T> {

    private List<T> response;
    private PageResponseDTO paging;

}
