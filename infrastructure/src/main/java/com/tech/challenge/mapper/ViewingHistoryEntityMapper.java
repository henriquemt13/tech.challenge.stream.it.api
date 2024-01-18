package com.tech.challenge.mapper;

import com.tech.challenge.entity.ViewingHistoryEntity;
import com.tech.challenge.model.ViewingHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ViewingHistoryEntityMapper extends BaseMapper<ViewingHistory, ViewingHistoryEntity> {
}
