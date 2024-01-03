package com.tech.challenge.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String username;
    private List<Category> likedCategories;
    private List<Category> dislikedCategories;
    private List<Video> publishedVideos;
}
