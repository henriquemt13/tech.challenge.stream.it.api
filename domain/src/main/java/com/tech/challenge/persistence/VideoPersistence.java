package com.tech.challenge.persistence;

import com.tech.challenge.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface VideoPersistence {

    Video save(Video video, MultipartFile videoFile) throws IOException;

    void delete(Video video) throws IOException;

    Optional<Video> findById(Long id);

    List<Video> findByIdIn(List<Long> ids);

    List<Video> findByVideoNameLike(String name);

    List<Video> findRecommendedVideosByUserId(Long userId);

    Optional<Video> findByVideoPath(String videoPath);
}
