package com.tech.challenge.adapter;

import com.tech.challenge.entity.LikeEntity;
import com.tech.challenge.mapper.LikeEntityMapper;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LikeAdapter implements LikePersistence {

    private final LikeRepository repository;
    private final LikeEntityMapper mapper;

    @Override
    public void likeVideo(Long videoId, Long userId) {
        LikeEntity like = new LikeEntity(videoId, userId, LikeOptionEnum.LIKE.name());
        repository.save(like);
    }

    @Override
    public void dislikeVideo(Long videoId, Long userId) {
        LikeEntity dislike = new LikeEntity(videoId, userId, LikeOptionEnum.DISLIKE.name());
        repository.save(dislike);
    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }

    @Override
    public List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOption) {
        return mapper.toDomain(repository.findByUserIdAndLikeOption(userId, likeOption.name()));
    }

    @Override
    public Optional<Like> findByUserIdAndVideoId(Long userId, Long videoId) {
        return repository.findByUserIdAndVideoId(userId, videoId).map(mapper::toDomain);
    }

    @Override
    public void delete(Like like) {
        repository.delete(mapper.toEntity(like));
    }
}
