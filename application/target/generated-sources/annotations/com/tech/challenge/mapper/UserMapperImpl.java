package com.tech.challenge.mapper;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.request.UserRequestDTO;
import com.tech.challenge.dto.response.PageResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import com.tech.challenge.dto.response.UserResponseDTO;
import com.tech.challenge.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T13:19:48-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User createRequestToDomain(UserRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( addDto.getUsername() );

        return user;
    }

    @Override
    public UserResponseDTO toResponse(User model) {
        if ( model == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( model.getId() );
        userResponseDTO.setUsername( model.getUsername() );
        userResponseDTO.setCreatedAt( model.getCreatedAt() );

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> toResponse(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( models.size() );
        for ( User user : models ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public SearchResultResponseDTO<UserResponseDTO> toResponse(SearchResultDTO<User> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        SearchResultResponseDTO<UserResponseDTO> searchResultResponseDTO = new SearchResultResponseDTO<UserResponseDTO>();

        searchResultResponseDTO.setPaging( toResponsePage( pageResponse ) );
        searchResultResponseDTO.setResponse( toResponse( pageResponse.getResponse() ) );

        return searchResultResponseDTO;
    }

    @Override
    public PageResponseDTO toResponsePage(SearchResultDTO<User> pageResponse) {
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
