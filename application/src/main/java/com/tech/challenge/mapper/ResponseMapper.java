package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.response.PageResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface ResponseMapper<D, R> {

    R toResponse(D model);

    List<R> toResponse(List<D> models);

    @Mapping(target = "paging", source = "pageResponse", qualifiedByName = "toResponsePage")
    SearchResultResponseDTO<R> toResponse(SearchResultDTO<D> pageResponse);

    @Named("toResponsePage")
    PageResponseDTO toResponsePage(SearchResultDTO<D> pageResponse);

}