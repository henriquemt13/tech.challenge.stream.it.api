package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseDomainMapper<D, E> {

    D toDomain(E entity);

    List<D> toDomain(List<E> entity);

    @Mapping(source = "page.totalPages", target = "totalPages")
    @Mapping(source = "page.totalElements", target = "totalElements")
    @Mapping(qualifiedByName = "getNumber", source = "page", target = "page")
    @Mapping(qualifiedByName = "getNumberOfElements", source = "page", target = "elementsPerPage")
    @Mapping(qualifiedByName = "getContent", source = "page", target = "response")
    SearchResultDTO<D> toDomain(Page<E> page);

    @Named("getNumberOfElements")
    default Integer getNumberOfElements(Page<E> page) {
        return page.getNumberOfElements();
    }

    @Named("getNumber")
    default Integer getNumber(Page<E> page) {
        return page.getNumber();
    }

    @Named("getContent")
    default List<D> getContent(Page<E> page) {
        return toDomain(page.getContent());
    }

}