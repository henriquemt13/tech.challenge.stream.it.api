package com.tech.challenge.service.impl;

import com.tech.challenge.model.Category;
import com.tech.challenge.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Override
    public void likeCategory(Long userId, Long categoryId) {

    }

    @Override
    public void dislikeCategory(Long userId, Long categoryId) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }
}
