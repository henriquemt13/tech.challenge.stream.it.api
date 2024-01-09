package com.tech.challenge.adapter;

import com.tech.challenge.model.Category;
import com.tech.challenge.persistence.CategoryPersistence;
import com.tech.challenge.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryAdapter implements CategoryPersistence {

    private CategoryRepository repository;

    @Override
    public void likeCategory(Long userId, Long categoryId) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findByVideoId(Long videoId) {
        return null;
    }

    @Override
    public List<Category> findDistinctByVideoIdIn(List<Long> videoIds) {
        return null;
    }
}
