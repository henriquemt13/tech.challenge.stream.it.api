package com.tech.challenge.mapper;

import com.tech.challenge.dto.request.UserRequestDTO;
import com.tech.challenge.dto.response.UserResponseDTO;
import com.tech.challenge.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends
        ResponseMapper<User, UserResponseDTO>,
        CreateRequestMapper<User, UserRequestDTO> {

}