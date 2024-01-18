package com.tech.challenge.repository;

import com.tech.challenge.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByIdIn(List<Long> ids);

}
