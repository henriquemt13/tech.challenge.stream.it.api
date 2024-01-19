package com.tech.challenge.mapper;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
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
public class LikeEntityMapperImpl implements LikeEntityMapper {

    @Override
    public List<LikeEntity> toEntity(List<Like> models) {
        if ( models == null ) {
            return null;
        }

        List<LikeEntity> list = new ArrayList<LikeEntity>( models.size() );
        for ( Like like : models ) {
            list.add( toEntity( like ) );
        }

        return list;
    }

    @Override
    public Like toDomain(LikeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Like like = new Like();

        like.setId( entity.getId() );
        like.setVideoId( entity.getVideoId() );
        like.setUserId( entity.getUserId() );
        if ( entity.getLikeOption() != null ) {
            like.setLikeOption( Enum.valueOf( LikeOptionEnum.class, entity.getLikeOption() ) );
        }
        like.setCreatedAt( entity.getCreatedAt() );

        return like;
    }

    @Override
    public List<Like> toDomain(List<LikeEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<Like> list = new ArrayList<Like>( entity.size() );
        for ( LikeEntity likeEntity : entity ) {
            list.add( toDomain( likeEntity ) );
        }

        return list;
    }

    @Override
    public void update(LikeEntity entity, Like model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setVideoId( model.getVideoId() );
        entity.setUserId( model.getUserId() );
        if ( model.getLikeOption() != null ) {
            entity.setLikeOption( model.getLikeOption().name() );
        }
        else {
            entity.setLikeOption( null );
        }
        entity.setCreatedAt( model.getCreatedAt() );
    }

    @Override
    public LikeEntity toEntity(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeEntity likeEntity = new LikeEntity();

        likeEntity.setLikeOption( getLikeOption( like.getLikeOption() ) );
        likeEntity.setId( like.getId() );
        likeEntity.setVideoId( like.getVideoId() );
        likeEntity.setUserId( like.getUserId() );
        likeEntity.setCreatedAt( like.getCreatedAt() );

        return likeEntity;
    }
}
