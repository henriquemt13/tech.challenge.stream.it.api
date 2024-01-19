package com.tech.challenge.mapper;

import com.tech.challenge.dto.response.CategoryResponseDTO;
import com.tech.challenge.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends
        ResponseMapper<Category, CategoryResponseDTO> {
}
