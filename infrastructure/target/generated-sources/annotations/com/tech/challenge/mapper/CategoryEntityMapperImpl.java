package com.tech.challenge.mapper;

import com.tech.challenge.entity.CategoryEntity;
import com.tech.challenge.model.Category;
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
public class CategoryEntityMapperImpl implements CategoryEntityMapper {

    @Override
    public CategoryEntity toEntity(Category model) {
        if ( model == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( model.getId() );
        categoryEntity.setName( model.getName() );
        categoryEntity.setCreatedAt( model.getCreatedAt() );

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> toEntity(List<Category> models) {
        if ( models == null ) {
            return null;
        }

        List<CategoryEntity> list = new ArrayList<CategoryEntity>( models.size() );
        for ( Category category : models ) {
            list.add( toEntity( category ) );
        }

        return list;
    }

    @Override
    public Category toDomain(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( entity.getId() );
        category.setName( entity.getName() );
        category.setCreatedAt( entity.getCreatedAt() );

        return category;
    }

    @Override
    public List<Category> toDomain(List<CategoryEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( entity.size() );
        for ( CategoryEntity categoryEntity : entity ) {
            list.add( toDomain( categoryEntity ) );
        }

        return list;
    }

    @Override
    public void update(CategoryEntity entity, Category model) {
        if ( model == null ) {
            return;
        }

        entity.setId( model.getId() );
        entity.setName( model.getName() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
