package com.tech.challenge.mapper;

import com.tech.challenge.entity.VideoEntity;
import com.tech.challenge.model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VideoEntityMapper extends BaseMapper<Video, VideoEntity> {
}
