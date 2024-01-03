package com.tech.challenge.model;

import lombok.Data;

import java.util.List;

@Data
public class Video {

    private Long id;
    private String videoName;
    private String videoDescription;
    private List<Category> categories;
    private Long uploaderUserId;
    private byte[] videoFile;
}
