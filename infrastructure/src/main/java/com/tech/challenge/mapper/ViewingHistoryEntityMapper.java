package com.tech.challenge.mapper;

import com.tech.challenge.entity.ViewingHistoryEntity;
import com.tech.challenge.model.ViewingHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ViewingHistoryEntityMapper extends BaseMapper<ViewingHistory, ViewingHistoryEntity> {
}
