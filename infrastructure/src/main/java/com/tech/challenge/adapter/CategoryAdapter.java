package com.tech.challenge.adapter;

import com.tech.challenge.entity.CategoryEntity;
import com.tech.challenge.mapper.CategoryEntityMapper;
import com.tech.challenge.model.Category;
import com.tech.challenge.persistence.CategoryPersistence;
import com.tech.challenge.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryAdapter implements CategoryPersistence {

    private CategoryRepository repository;
    private CategoryEntityMapper mapper;
    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categories = new ArrayList<>();
        repository.findAll().forEach(categories::add);
        return mapper.toDomain(categories);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return mapper.toDomain(repository.findById(id));
    }

    @Override
    public List<Category> findByIdIn(List<Long> ids) {
        return repository.findByIdIn(ids);
    }

    @Override
    public List<Category> findByVideoId(Long videoId) {
        return mapper.toDomain(repository.findByVideoId(videoId));
    }

}
