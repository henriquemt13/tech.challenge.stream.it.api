package com.tech.challenge.mapper;

import com.tech.challenge.entity.VideoEntity;
import com.tech.challenge.model.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoEntityMapper extends BaseMapper<Video, VideoEntity> {
}
