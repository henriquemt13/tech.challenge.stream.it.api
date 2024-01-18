package com.tech.challenge.persistence;

import com.tech.challenge.model.Category;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findByIdIn(List<Long> ids);

}
