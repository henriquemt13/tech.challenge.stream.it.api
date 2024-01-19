package com.tech.challenge.specification;

import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.entity.VideoEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import com.tech.challenge.model.Video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
public class SearchVideoSpecification {

    private SearchVideoSpecification() {
    }

    public static Specification<VideoEntity> search(SearchVideoDTO filter) {
        return (video, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(filter.getVideoName())) {
                predicates.add(cb.like(video.get("videoName"),
                        String.format("%s%s%s","%", filter.getVideoName(), "%")));
            }

            if (Objects.nonNull(filter.getUploadDate())) {
                predicates.add(cb.greaterThanOrEqualTo(video.get("uploadDate"),
                        filter.getUploadDate()));
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
