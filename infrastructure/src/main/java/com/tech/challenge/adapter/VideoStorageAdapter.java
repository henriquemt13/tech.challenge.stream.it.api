package com.tech.challenge.adapter;

import com.tech.challenge.storage.VideoStorage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class VideoStorageAdapter implements VideoStorage {

    private static String UPLOAD_DIRECTORY = System.getProperty("user.home");

    @Override
    public Mono<String> uploadVideo(Long userId, MultipartFile videoFile) throws IOException {
        String filename = UUID.randomUUID() + "-" + userId.toString() + "-" + videoFile.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIRECTORY).resolve(filename);
        videoFile.transferTo(filePath.toFile());
        return Mono.just(filename);
    }

    @Override
    public Mono<Resource> streamVideo(String videoPath) throws MalformedURLException {
        return Mono.just(new UrlResource(Paths.get(videoPath).toUri()));
    }

    @Override
    public void deleteVideo(String videoPath) throws IOException {
        Files.deleteIfExists(Paths.get(videoPath));
    }
}
