package com.tech.challenge.mapper;

import com.tech.challenge.dto.MetricsDTO;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.response.MetricsResponseDTO;
import com.tech.challenge.dto.response.PageResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T13:55:42-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MetricsMapperImpl implements MetricsMapper {

    @Override
    public MetricsResponseDTO toResponse(MetricsDTO model) {
        if ( model == null ) {
            return null;
        }

        MetricsResponseDTO metricsResponseDTO = new MetricsResponseDTO();

        metricsResponseDTO.setTotalVideos( model.getTotalVideos() );
        metricsResponseDTO.setTotalInteractions( model.getTotalInteractions() );
        metricsResponseDTO.setTotalLikes( model.getTotalLikes() );
        metricsResponseDTO.setTotalViews( model.getTotalViews() );

        return metricsResponseDTO;
    }

    @Override
    public List<MetricsResponseDTO> toResponse(List<MetricsDTO> models) {
        if ( models == null ) {
            return null;
        }

        List<MetricsResponseDTO> list = new ArrayList<MetricsResponseDTO>( models.size() );
        for ( MetricsDTO metricsDTO : models ) {
            list.add( toResponse( metricsDTO ) );
        }

        return list;
    }

    @Override
    public SearchResultResponseDTO<MetricsResponseDTO> toResponse(SearchResultDTO<MetricsDTO> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        SearchResultResponseDTO<MetricsResponseDTO> searchResultResponseDTO = new SearchResultResponseDTO<MetricsResponseDTO>();

        searchResultResponseDTO.setPaging( toResponsePage( pageResponse ) );
        searchResultResponseDTO.setResponse( toResponse( pageResponse.getResponse() ) );

        return searchResultResponseDTO;
    }

    @Override
    public PageResponseDTO toResponsePage(SearchResultDTO<MetricsDTO> pageResponse) {
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
}
