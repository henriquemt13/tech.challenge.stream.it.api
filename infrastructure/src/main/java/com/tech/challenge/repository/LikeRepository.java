package com.tech.challenge.repository;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {

    List<LikeEntity> findByUserId(Long userId);

    List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOption)
}
