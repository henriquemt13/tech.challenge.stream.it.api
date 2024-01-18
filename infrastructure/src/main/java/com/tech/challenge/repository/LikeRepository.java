package com.tech.challenge.repository;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.model.LikeOptionEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {

    List<LikeEntity> findByUserId(Long userId);

    List<LikeEntity> findByUserIdAndLikeOption(Long userId, String likeOption);

    Optional<LikeEntity> findByUserIdAndVideoId(Long userId, Long videoId);
}
