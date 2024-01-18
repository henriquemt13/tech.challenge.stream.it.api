package com.tech.challenge.mapper;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LikeEntityMapper extends BaseMapper<Like, LikeEntity> {

    @Override
    @Mapping(source = "like.likeOption", target = "likeOption", qualifiedByName = "getLikeOption")
    LikeEntity toEntity(Like like);

    @Named("getLikeOption")
    default String getLikeOption(LikeOptionEnum likeOptionEnum) {
        return likeOptionEnum.name();
    }
}
