package com.tech.challenge.adapter;

import com.tech.challenge.model.Video;
import com.tech.challenge.storage.VideoStorage;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

@Component
public class VideoStorageAdapter implements VideoStorage {

    private static final String UPLOAD_DIRECTORY = System.getProperty("user.home");

    @Override
    public String uploadVideo(Video video, MultipartFile videoFile) throws IOException {
        var filename = generateFileName(video, videoFile);
        Path filePath = Paths.get(UPLOAD_DIRECTORY).resolve(filename);
        videoFile.transferTo(filePath.toFile());
        return filename;
    }

    private String generateFileName(Video video, MultipartFile videoFile) {
        var fileName = video.getVideoName();
        var fileExtension = StringUtils.getFilenameExtension(videoFile.getOriginalFilename());
        return String.format("%s.%s", Base64.getEncoder()
                .encodeToString(Objects.requireNonNull(fileName).getBytes()), fileExtension);
    }

    @Override
    public Mono<Resource> streamVideo(String videoPath) throws MalformedURLException {
        String videoPathWithoutExtension = videoPath.substring(0, videoPath.length()-4);
        String extension = videoPath.substring(videoPath.length()-3);
        return Mono.just(new UrlResource(Paths.get(String.format("%s/%s.%s", UPLOAD_DIRECTORY,
                        videoPathWithoutExtension, extension)).toUri()));
    }

    @Override
    public void deleteVideo(String videoPath) throws IOException {
        Files.deleteIfExists(Paths.get(videoPath));
    }
}
