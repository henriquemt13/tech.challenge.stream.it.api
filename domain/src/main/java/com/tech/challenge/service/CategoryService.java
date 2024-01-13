package com.tech.challenge.service;

import com.tech.challenge.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void likeCategory(Long userId, Long categoryId);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findByIdIn(List<Long> ids);

    List<Category> findByVideoId(Long videoId);

}
