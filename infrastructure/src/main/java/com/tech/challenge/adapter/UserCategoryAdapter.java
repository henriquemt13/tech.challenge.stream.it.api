package com.tech.challenge.adapter;

import com.tech.challenge.mapper.UserCategoriesEntityMapper;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoryPersistence;
import com.tech.challenge.repository.UserCategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserCategoryAdapter implements UserCategoryPersistence {

    private UserCategoriesRepository repository;
    private UserCategoriesEntityMapper mapper;

    @Override
    public UserCategories save(UserCategories userCategories) {
        return mapper.toDomain(repository.save(mapper.toEntity(userCategories)));
    }

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }

    @Override
    public List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return mapper.toDomain(repository.findByUserIdAndLikeOption(userId, likeOptionEnum.name()));
    }
}
