package com.tech.challenge.adapter;

import com.tech.challenge.mapper.UserCategoriesEntityMapper;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoriesPersistence;
import com.tech.challenge.repository.UserCategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCategoriesAdapter implements UserCategoriesPersistence {

    private final UserCategoriesRepository repository;
    private final UserCategoriesEntityMapper mapper;

    @Override
    public UserCategories save(UserCategories userCategories) {
        return mapper.toDomain(repository.save(mapper.toEntity(userCategories)));
    }

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }

}
