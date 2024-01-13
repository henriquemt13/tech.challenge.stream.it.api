package com.tech.challenge.repository;

import com.tech.challenge.entity.CategoryEntity;
import com.tech.challenge.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    List<Category> findByIdIn(List<Long> ids);
    List<CategoryEntity> findByVideoId(Long videoId);

}
