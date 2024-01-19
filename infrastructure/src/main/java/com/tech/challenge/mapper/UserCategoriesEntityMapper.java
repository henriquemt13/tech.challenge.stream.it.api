package com.tech.challenge.mapper;

import com.tech.challenge.entity.UserCategoriesEntity;
import com.tech.challenge.model.UserCategories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCategoriesEntityMapper extends BaseMapper<UserCategories, UserCategoriesEntity> {
}
