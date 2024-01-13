package com.tech.challenge.repository;

import com.tech.challenge.entity.VideoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface VideoRepository extends ReactiveCrudRepository<VideoEntity, Long> {

    Flux<VideoEntity> findByIdIn(List<Long> ids);

    Flux<VideoEntity> findByVideoNameLike(String name);

    @Query("SELECT DISTINCT v FROM Video v " +
            "JOIN v.categories c " +
            "WHERE c.id IN " +
            "(SELECT DISTINCT uc.categoryId FROM UserCategory uc WHERE uc.userId = :userId AND uc.likeOption = 'LIKE' " +
            "UNION " +
            "SELECT DISTINCT vc.categoryId FROM VideoCategories vc " +
            "WHERE vc.videoId IN (SELECT l.videoId FROM Like l WHERE l.userId = :userId) " +
            "ORDER BY (SELECT MAX(l.createdAt) FROM Like l WHERE l.videoId = v.id) DESC) " +
            "AND v.id NOT IN (SELECT vh.videoId FROM ViewingHistory vh WHERE vh.userId = :userId) " +
            "ORDER BY v.uploadDate ASC")
    Flux<VideoEntity> findRecommendedVideosByUserId(Long userId);
}
