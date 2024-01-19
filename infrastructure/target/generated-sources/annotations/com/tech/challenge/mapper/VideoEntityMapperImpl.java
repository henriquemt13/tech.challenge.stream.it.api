package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.entity.VideoEntity;
import com.tech.challenge.model.Video;
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
public class VideoEntityMapperImpl implements VideoEntityMapper {

    @Override
    public VideoEntity toEntity(Video model) {
        if ( model == null ) {
            return null;
        }

        VideoEntity videoEntity = new VideoEntity();

        videoEntity.setId( model.getId() );
        videoEntity.setVideoName( model.getVideoName() );
        videoEntity.setVideoDescription( model.getVideoDescription() );
        videoEntity.setVideoPath( model.getVideoPath() );
        videoEntity.setUploaderUserId( model.getUploaderUserId() );
        videoEntity.setUploadDate( model.getUploadDate() );

        return videoEntity;
    }

    @Override
    public List<VideoEntity> toEntity(List<Video> models) {
        if ( models == null ) {
            return null;
        }

        List<VideoEntity> list = new ArrayList<VideoEntity>( models.size() );
        for ( Video video : models ) {
            list.add( toEntity( video ) );
        }

        return list;
    }

    @Override
    public Video toDomain(VideoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Video video = new Video();

        video.setId( entity.getId() );
        video.setUploaderUserId( entity.getUploaderUserId() );
        video.setVideoName( entity.getVideoName() );
        video.setVideoDescription( entity.getVideoDescription() );
        video.setVideoPath( entity.getVideoPath() );
        video.setUploadDate( entity.getUploadDate() );

        return video;
    }

    @Override
    public List<Video> toDomain(List<VideoEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<Video> list = new ArrayList<Video>( entity.size() );
        for ( VideoEntity videoEntity : entity ) {
            list.add( toDomain( videoEntity ) );
        }

        return list;
    }

    @Override
    public SearchResultDTO<Video> toDomain(Page<VideoEntity> page) {
        if ( page == null ) {
            return null;
        }

        SearchResultDTO<Video> searchResultDTO = new SearchResultDTO<Video>();

        searchResultDTO.setTotalPages( page.getTotalPages() );
        searchResultDTO.setTotalElements( page.getTotalElements() );
        searchResultDTO.setPage( getNumber( page ) );
        searchResultDTO.setElementsPerPage( getNumberOfElements( page ) );
        searchResultDTO.setResponse( getContent( page ) );

        return searchResultDTO;
    }

    @Override
    public void update(VideoEntity entity, Video model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setVideoName( model.getVideoName() );
        entity.setVideoDescription( model.getVideoDescription() );
        entity.setVideoPath( model.getVideoPath() );
        entity.setUploaderUserId( model.getUploaderUserId() );
        entity.setUploadDate( model.getUploadDate() );
    }
}
