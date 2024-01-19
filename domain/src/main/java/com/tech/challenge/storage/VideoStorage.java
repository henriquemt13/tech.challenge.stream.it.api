package com.tech.challenge.storage;

import com.tech.challenge.model.Video;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;

public interface VideoStorage {

    String uploadVideo(Video video, MultipartFile videoFile) throws IOException;

    Mono<Resource> streamVideo(String videoPath) throws MalformedURLException;

    void deleteVideo(String videoPath) throws IOException;
}
