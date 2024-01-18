package com.tech.challenge.mapper;

import com.tech.challenge.entity.UserCategoriesEntity;
import com.tech.challenge.model.UserCategories;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T23:49:26-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserCategoriesEntityMapperImpl implements UserCategoriesEntityMapper {

    @Override
    public UserCategoriesEntity toEntity(UserCategories model) {
        if ( model == null ) {
            return null;
        }

        UserCategoriesEntity userCategoriesEntity = new UserCategoriesEntity();

        userCategoriesEntity.setId( model.getId() );
        userCategoriesEntity.setUserId( model.getUserId() );
        userCategoriesEntity.setCategoryId( model.getCategoryId() );
        userCategoriesEntity.setCreatedAt( model.getCreatedAt() );

        return userCategoriesEntity;
    }

    @Override
    public List<UserCategoriesEntity> toEntity(List<UserCategories> models) {
        if ( models == null ) {
            return null;
        }

        List<UserCategoriesEntity> list = new ArrayList<UserCategoriesEntity>( models.size() );
        for ( UserCategories userCategories : models ) {
            list.add( toEntity( userCategories ) );
        }

        return list;
    }

    @Override
    public UserCategories toDomain(UserCategoriesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserCategories userCategories = new UserCategories();

        userCategories.setId( entity.getId() );
        userCategories.setUserId( entity.getUserId() );
        userCategories.setCategoryId( entity.getCategoryId() );
        userCategories.setCreatedAt( entity.getCreatedAt() );

        return userCategories;
    }

    @Override
    public List<UserCategories> toDomain(List<UserCategoriesEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserCategories> list = new ArrayList<UserCategories>( entity.size() );
        for ( UserCategoriesEntity userCategoriesEntity : entity ) {
            list.add( toDomain( userCategoriesEntity ) );
        }

        return list;
    }

    @Override
    public void update(UserCategoriesEntity entity, UserCategories model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setUserId( model.getUserId() );
        entity.setCategoryId( model.getCategoryId() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
