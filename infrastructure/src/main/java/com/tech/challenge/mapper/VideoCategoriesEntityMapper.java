package com.tech.challenge.mapper;

import com.tech.challenge.entity.VideoCategoriesEntity;
import com.tech.challenge.model.VideoCategories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoCategoriesEntityMapper extends BaseMapper<VideoCategories, VideoCategoriesEntity> {
}
