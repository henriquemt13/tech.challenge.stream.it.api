package com.tech.challenge.mapper;

import com.tech.challenge.entity.UserEntity;
import com.tech.challenge.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends BaseMapper<User, UserEntity> {
}
