package com.tech.challenge.repository;

import com.tech.challenge.entity.VideoCategoriesEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VideoCategoriesRepository extends CrudRepository<VideoCategoriesEntity, Long> {

    List<VideoCategoriesEntity> findByVideoId(Long videoId);

    List<VideoCategoriesEntity> findByCategoryIdIn(List<Long> categoryIds);
}
