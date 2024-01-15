package com.tech.challenge.persistence;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;

import java.util.List;

public interface UserCategoriesPersistence {

    UserCategories save(UserCategories userCategories);

    List<UserCategories> findByUserId(Long userId);

    List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum);
}
