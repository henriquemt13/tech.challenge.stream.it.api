package com.tech.challenge.repository;

import com.tech.challenge.entity.UserCategoriesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCategoriesRepository extends CrudRepository<UserCategoriesEntity, Long> {

    List<UserCategoriesEntity> findByUserId(Long userId);

}
