package com.tech.challenge.service.impl;

import com.tech.challenge.model.Category;
import com.tech.challenge.persistence.CategoryPersistence;
import com.tech.challenge.service.CategoryService;
import com.tech.challenge.service.UserCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryPersistence persistence;
    private UserCategoriesService userCategoriesService;

    @Override
    public void likeCategory(Long userId, Long categoryId) {
        userCategoriesService.save(userId, categoryId);
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
    public List<Category> findByIdIn(List<Long> ids) {
        return persistence.findByIdIn(ids);
    }

    @Override
    public List<Category> findByVideoId(Long videoId) {
        return persistence.findByVideoId(videoId);
    }

}
