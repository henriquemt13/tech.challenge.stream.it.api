package com.tech.challenge.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Pagination details")
public class PageResponseDTO {

    @Schema(description = "The number of total pages", example = "10")
    private Integer totalPages;

    @Schema(description = "The number of total elements", example = "100")
    private Long totalElements;

    @Schema(description = "The number of the current page", example = "1")
    private Integer page;

    @Schema(description = "The number of elements per page", example = "10")
    private Integer elementsPerPage;
}