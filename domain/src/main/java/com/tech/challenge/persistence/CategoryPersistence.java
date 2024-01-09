package com.tech.challenge.persistence;

import com.tech.challenge.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {

    void likeCategory(Long userId, Long categoryId);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findByVideoId(Long videoId);

    List<Category> findDistinctByVideoIdIn(List<Long> videoIds);
}
