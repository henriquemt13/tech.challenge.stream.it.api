package com.tech.challenge.mapper;

import com.tech.challenge.entity.UserEntity;
import com.tech.challenge.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T21:54:36-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserEntity toEntity(User model) {
        if ( model == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( model.getId() );
        userEntity.setUsername( model.getUsername() );
        userEntity.setCreatedAt( model.getCreatedAt() );

        return userEntity;
    }

    @Override
    public List<UserEntity> toEntity(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( models.size() );
        for ( User user : models ) {
            list.add( toEntity( user ) );
        }

        return list;
    }

    @Override
    public User toDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User user = new User();

        user.setId( entity.getId() );
        user.setUsername( entity.getUsername() );
        user.setCreatedAt( entity.getCreatedAt() );

        return user;
    }

    @Override
    public List<User> toDomain(List<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( entity.size() );
        for ( UserEntity userEntity : entity ) {
            list.add( toDomain( userEntity ) );
        }

        return list;
    }

    @Override
    public void update(UserEntity entity, User model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setUsername( model.getUsername() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
