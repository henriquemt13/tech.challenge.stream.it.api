package com.tech.challenge.repository;

import com.tech.challenge.entity.VideoEntity;
import com.tech.challenge.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends PagingAndSortingRepository<VideoEntity, Long>,
        CrudRepository<VideoEntity, Long>, JpaSpecificationExecutor<VideoEntity> {

    Page<VideoEntity> findByIdIn(List<Long> ids, PageRequest pageRequest);

    List<VideoEntity> findByIdIn(List<Long> ids);

    @Query(value = "SELECT DISTINCT v.* " +
            "FROM video v  " +
            "JOIN video_categories vc ON vc.video_id = v.id  " +
            "WHERE vc.category_id IN (  " +
            "    SELECT DISTINCT uc.category_id " +
            "    FROM user_categories uc  " +
            "    WHERE uc.user_id = :userId  " +
            "" +
            "    UNION  " +
            "" +
            "    SELECT DISTINCT vcu.category_id " +
            "    FROM video_categories vcu  " +
            "    WHERE vcu.video_id IN (  " +
            "        SELECT l.video_id " +
            "        FROM like_table l  " +
            "        WHERE l.user_id = :userId" +
            "    )  " +
            ")  " +
            "AND v.id NOT IN (" +
            "    SELECT vh.video_id " +
            "    FROM viewing_history vh " +
            "    WHERE vh.user_id = :userId" +
            ")  " +
            "ORDER BY v.created_at DESC;", nativeQuery = true)
    List<VideoEntity> findRecommendedVideosByUserId(Long userId);


    Optional<VideoEntity> findByVideoPath(String videoPath);
}
