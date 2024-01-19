package com.tech.challenge.mapper;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.dto.response.VideoResponseDTO;
import com.tech.challenge.model.Video;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T21:56:36-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class VideoMapperImpl implements VideoMapper {

    @Override
    public CreateVideoDTO createRequestToDomain(CreateVideoRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        CreateVideoDTO createVideoDTO = new CreateVideoDTO();

        createVideoDTO.setVideo( addDto.getVideo() );
        List<Long> list = addDto.getCategoryIds();
        if ( list != null ) {
            createVideoDTO.setCategoryIds( new ArrayList<Long>( list ) );
        }
        createVideoDTO.setVideoName( addDto.getVideoName() );
        createVideoDTO.setVideoDescription( addDto.getVideoDescription() );

        return createVideoDTO;
    }

    @Override
    public VideoResponseDTO toResponse(Video model) {
        if ( model == null ) {
            return null;
        }

        Long id = null;
        Long uploaderUserId = null;
        String videoName = null;
        String videoDescription = null;
        String videoPath = null;
        LocalDateTime uploadDate = null;

        id = model.getId();
        uploaderUserId = model.getUploaderUserId();
        videoName = model.getVideoName();
        videoDescription = model.getVideoDescription();
        videoPath = model.getVideoPath();
        uploadDate = model.getUploadDate();

        VideoResponseDTO videoResponseDTO = new VideoResponseDTO( id, uploaderUserId, videoName, videoDescription, videoPath, uploadDate );

        return videoResponseDTO;
    }

    @Override
    public List<VideoResponseDTO> toResponse(List<Video> models) {
        if ( models == null ) {
            return null;
        }

        List<VideoResponseDTO> list = new ArrayList<VideoResponseDTO>( models.size() );
        for ( Video video : models ) {
            list.add( toResponse( video ) );
        }

        return list;
    }

    @Override
    public CreateVideoDTO createRequestToDomain(CreateVideoRequestDTO createVideoRequestDTO, Long userId) {
        if ( createVideoRequestDTO == null && userId == null ) {
            return null;
        }

        CreateVideoDTO createVideoDTO = new CreateVideoDTO();

        if ( createVideoRequestDTO != null ) {
            createVideoDTO.setVideo( createVideoRequestDTO.getVideo() );
            List<Long> list = createVideoRequestDTO.getCategoryIds();
            if ( list != null ) {
                createVideoDTO.setCategoryIds( new ArrayList<Long>( list ) );
            }
            createVideoDTO.setVideoName( createVideoRequestDTO.getVideoName() );
            createVideoDTO.setVideoDescription( createVideoRequestDTO.getVideoDescription() );
        }
        createVideoDTO.setUserId( userId );

        return createVideoDTO;
    }
}
