package com.tech.challenge.mapper;

import com.tech.challenge.entity.ViewingHistoryEntity;
import com.tech.challenge.model.ViewingHistory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T21:54:36-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ViewingHistoryEntityMapperImpl implements ViewingHistoryEntityMapper {

    @Override
    public ViewingHistoryEntity toEntity(ViewingHistory model) {
        if ( model == null ) {
            return null;
        }

        ViewingHistoryEntity viewingHistoryEntity = new ViewingHistoryEntity();

        viewingHistoryEntity.setId( model.getId() );
        viewingHistoryEntity.setUserId( model.getUserId() );
        viewingHistoryEntity.setVideoId( model.getVideoId() );
        viewingHistoryEntity.setCreatedAt( model.getCreatedAt() );

        return viewingHistoryEntity;
    }

    @Override
    public List<ViewingHistoryEntity> toEntity(List<ViewingHistory> models) {
        if ( models == null ) {
            return null;
        }

        List<ViewingHistoryEntity> list = new ArrayList<ViewingHistoryEntity>( models.size() );
        for ( ViewingHistory viewingHistory : models ) {
            list.add( toEntity( viewingHistory ) );
        }

        return list;
    }

    @Override
    public ViewingHistory toDomain(ViewingHistoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ViewingHistory viewingHistory = new ViewingHistory();

        viewingHistory.setId( entity.getId() );
        viewingHistory.setUserId( entity.getUserId() );
        viewingHistory.setVideoId( entity.getVideoId() );
        viewingHistory.setCreatedAt( entity.getCreatedAt() );

        return viewingHistory;
    }

    @Override
    public List<ViewingHistory> toDomain(List<ViewingHistoryEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ViewingHistory> list = new ArrayList<ViewingHistory>( entity.size() );
        for ( ViewingHistoryEntity viewingHistoryEntity : entity ) {
            list.add( toDomain( viewingHistoryEntity ) );
        }

        return list;
    }

    @Override
    public void update(ViewingHistoryEntity entity, ViewingHistory model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setUserId( model.getUserId() );
        entity.setVideoId( model.getVideoId() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
