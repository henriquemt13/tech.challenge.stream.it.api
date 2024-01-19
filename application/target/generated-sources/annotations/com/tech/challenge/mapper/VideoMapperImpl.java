package com.tech.challenge.mapper;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.dto.request.SearchVideoRequestDTO;
import com.tech.challenge.dto.response.PageResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import com.tech.challenge.dto.response.VideoResponseDTO;
import com.tech.challenge.model.Video;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T13:19:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class VideoMapperImpl implements VideoMapper {

    @Override
    public SearchVideoDTO createRequestToDomain(SearchVideoRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        SearchVideoDTO searchVideoDTO = new SearchVideoDTO();

        searchVideoDTO.setVideoName( addDto.getVideoName() );
        searchVideoDTO.setUploadDate( addDto.getUploadDate() );
        searchVideoDTO.setPage( addDto.getPage() );
        searchVideoDTO.setSize( addDto.getSize() );

        return searchVideoDTO;
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
    public SearchResultResponseDTO<VideoResponseDTO> toResponse(SearchResultDTO<Video> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        SearchResultResponseDTO<VideoResponseDTO> searchResultResponseDTO = new SearchResultResponseDTO<VideoResponseDTO>();

        searchResultResponseDTO.setPaging( toResponsePage( pageResponse ) );
        searchResultResponseDTO.setResponse( toResponse( pageResponse.getResponse() ) );

        return searchResultResponseDTO;
    }

    @Override
    public PageResponseDTO toResponsePage(SearchResultDTO<Video> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        PageResponseDTO.PageResponseDTOBuilder pageResponseDTO = PageResponseDTO.builder();

        pageResponseDTO.totalPages( pageResponse.getTotalPages() );
        pageResponseDTO.totalElements( pageResponse.getTotalElements() );
        pageResponseDTO.page( pageResponse.getPage() );
        pageResponseDTO.elementsPerPage( pageResponse.getElementsPerPage() );

        return pageResponseDTO.build();
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
