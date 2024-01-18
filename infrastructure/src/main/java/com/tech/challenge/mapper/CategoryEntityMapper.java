package com.tech.challenge.mapper;

import com.tech.challenge.entity.CategoryEntity;
import com.tech.challenge.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper extends BaseMapper<Category, CategoryEntity> {
}
