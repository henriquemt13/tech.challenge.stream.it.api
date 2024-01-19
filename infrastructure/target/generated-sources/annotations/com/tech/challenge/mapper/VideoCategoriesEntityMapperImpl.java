package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.entity.VideoCategoriesEntity;
import com.tech.challenge.model.VideoCategories;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T13:14:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class VideoCategoriesEntityMapperImpl implements VideoCategoriesEntityMapper {

    @Override
    public VideoCategoriesEntity toEntity(VideoCategories model) {
        if ( model == null ) {
            return null;
        }

        VideoCategoriesEntity videoCategoriesEntity = new VideoCategoriesEntity();

        videoCategoriesEntity.setId( model.getId() );
        videoCategoriesEntity.setVideoId( model.getVideoId() );
        videoCategoriesEntity.setCategoryId( model.getCategoryId() );
        videoCategoriesEntity.setCreatedAt( model.getCreatedAt() );

        return videoCategoriesEntity;
    }

    @Override
    public List<VideoCategoriesEntity> toEntity(List<VideoCategories> models) {
        if ( models == null ) {
            return null;
        }

        List<VideoCategoriesEntity> list = new ArrayList<VideoCategoriesEntity>( models.size() );
        for ( VideoCategories videoCategories : models ) {
            list.add( toEntity( videoCategories ) );
        }

        return list;
    }

    @Override
    public VideoCategories toDomain(VideoCategoriesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VideoCategories videoCategories = new VideoCategories();

        videoCategories.setId( entity.getId() );
        videoCategories.setVideoId( entity.getVideoId() );
        videoCategories.setCategoryId( entity.getCategoryId() );
        videoCategories.setCreatedAt( entity.getCreatedAt() );

        return videoCategories;
    }

    @Override
    public List<VideoCategories> toDomain(List<VideoCategoriesEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<VideoCategories> list = new ArrayList<VideoCategories>( entity.size() );
        for ( VideoCategoriesEntity videoCategoriesEntity : entity ) {
            list.add( toDomain( videoCategoriesEntity ) );
        }

        return list;
    }

    @Override
    public SearchResultDTO<VideoCategories> toDomain(Page<VideoCategoriesEntity> page) {
        if ( page == null ) {
            return null;
        }

        SearchResultDTO<VideoCategories> searchResultDTO = new SearchResultDTO<VideoCategories>();

        searchResultDTO.setTotalPages( page.getTotalPages() );
        searchResultDTO.setTotalElements( page.getTotalElements() );
        searchResultDTO.setPage( getNumber( page ) );
        searchResultDTO.setElementsPerPage( getNumberOfElements( page ) );
        searchResultDTO.setResponse( getContent( page ) );

        return searchResultDTO;
    }

    @Override
    public void update(VideoCategoriesEntity entity, VideoCategories model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setVideoId( model.getVideoId() );
        entity.setCategoryId( model.getCategoryId() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
