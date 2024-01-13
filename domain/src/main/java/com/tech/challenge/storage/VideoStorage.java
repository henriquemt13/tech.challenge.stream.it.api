package com.tech.challenge.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;

public interface VideoStorage {

    Mono<String> uploadVideo(Long userId, MultipartFile videoFile) throws IOException;

    Mono<Resource> streamVideo(String videoPath) throws MalformedURLException;

    void deleteVideo(String videoPath) throws IOException;
}
