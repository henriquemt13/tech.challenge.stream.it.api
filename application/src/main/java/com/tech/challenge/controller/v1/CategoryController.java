package com.tech.challenge.controller.v1;

import com.tech.challenge.dto.response.CategoryResponseDTO;
import com.tech.challenge.mapper.CategoryMapper;
import com.tech.challenge.usecase.CategoryUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Category")
public class CategoryController {

    private CategoryMapper mapper;
    private CategoryUseCases categoryUseCases;

    @GetMapping("/")
    @ApiResponse(description = "Find All Categories", responseCode = "200")
    @Operation(summary = "Find All")
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findAll()));
    }

    @GetMapping("/video/{id}")
    @ApiResponse(description = "Find Categories By VideoId", responseCode = "200")
    @Operation(summary = "Find All")
    public ResponseEntity<List<CategoryResponseDTO>> findByVideoId(@Valid @PathVariable Long videoId) {
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findByVideoId(videoId)));
    }

    @GetMapping("/user/{id}/like-categories")
    @ApiResponse(description = "Find Liked Categories by User Id", responseCode = "200")
    @Operation(summary = "Get User by UserId")
    public ResponseEntity<List<CategoryResponseDTO>> findLikedCategories(@Valid @PathVariable Long userId) {
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findUserLikedCategories(userId)));
    }

    @PostMapping("/user/{id}/like-categories")
    @ApiResponse(description = "Save User", responseCode = "200")
    @Operation(summary = "Get User by UserId")
    public ResponseEntity<Void> likeCategories(@Valid @PathVariable Long userId,
                                               @Valid @ParameterObject List<Long> categoriesIds) {
        categoryUseCases.likeCategories(userId, categoriesIds);
        return ResponseEntity.ok().build();
    }
}
