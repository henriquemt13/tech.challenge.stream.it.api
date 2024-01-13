package com.tech.challenge.adapter;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.mapper.LikeEntityMapper;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LikeAdapter implements LikePersistence {

    private LikeRepository repository;
    private LikeEntityMapper mapper;

    @Override
    public void likeVideo(Long videoId, Long userId) {
        LikeEntity like = new LikeEntity(videoId, userId, LikeOptionEnum.LIKE);
        repository.save(like);
    }

    @Override
    public void dislikeVideo(Long videoId, Long userId) {
        LikeEntity dislike = new LikeEntity(videoId, userId, LikeOptionEnum.DISLIKE);
        repository.save(dislike);
    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }

    @Override
    public List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOption) {
        return repository.findByUserIdAndLikeOption(userId, likeOption);
    }
}
