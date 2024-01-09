package com.tech.challenge.service.impl;

import com.tech.challenge.model.Category;
import com.tech.challenge.persistence.CategoryPersistence;
import com.tech.challenge.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryPersistence persistence;

    @Override
    public void likeCategory(Long userId, Long categoryId) {
        persistence.likeCategory(userId, categoryId);
    }

    @Override
    public List<Category> findAll() {
        return persistence.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public List<Category> findByVideoId(Long videoId) {
        return persistence.findByVideoId(videoId);
    }

    @Override
    public List<Category> findDistinctByVideoIdIn(List<Long> videoIds) {
        return persistence.findDistinctByVideoIdIn(videoIds);
    }
}
