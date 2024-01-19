package com.tech.challenge.mapper;

import com.tech.challenge.dto.response.CategoryResponseDTO;
import com.tech.challenge.model.Category;
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
}
