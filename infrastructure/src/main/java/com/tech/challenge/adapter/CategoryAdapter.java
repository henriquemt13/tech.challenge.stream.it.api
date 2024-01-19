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

    private final CategoryRepository repository;
    private final CategoryEntityMapper mapper;

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categories = new ArrayList<>();
        repository.findAll().forEach(categories::add);
        return mapper.toDomain(categories);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Category> findByIdIn(List<Long> ids) {
        return mapper.toDomain(repository.findByIdIn(ids));
    }

}
