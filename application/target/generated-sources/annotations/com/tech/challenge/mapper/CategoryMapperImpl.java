package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.response.CategoryResponseDTO;
import com.tech.challenge.dto.response.PageResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import com.tech.challenge.model.Category;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponseDTO toResponse(Category model) {
        if ( model == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        LocalDateTime createdAt = null;

        id = model.getId();
        name = model.getName();
        createdAt = model.getCreatedAt();

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO( id, name, createdAt );

        return categoryResponseDTO;
    }

    @Override
    public List<CategoryResponseDTO> toResponse(List<Category> models) {
        if ( models == null ) {
            return null;
        }

        List<CategoryResponseDTO> list = new ArrayList<CategoryResponseDTO>( models.size() );
        for ( Category category : models ) {
            list.add( toResponse( category ) );
        }

        return list;
    }

    @Override
    public SearchResultResponseDTO<CategoryResponseDTO> toResponse(SearchResultDTO<Category> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        SearchResultResponseDTO<CategoryResponseDTO> searchResultResponseDTO = new SearchResultResponseDTO<CategoryResponseDTO>();

        searchResultResponseDTO.setPaging( toResponsePage( pageResponse ) );
        searchResultResponseDTO.setResponse( toResponse( pageResponse.getResponse() ) );

        return searchResultResponseDTO;
    }

    @Override
    public PageResponseDTO toResponsePage(SearchResultDTO<Category> pageResponse) {
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
