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

    private final CategoryMapper mapper;
    private final CategoryUseCases categoryUseCases;

    @GetMapping
    @ApiResponse(description = "Find All Categories", responseCode = "200")
    @Operation(summary = "Find All")
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        log.info("Searching for all Categories");
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findAll()));
    }

    @GetMapping("/video/{id}")
    @ApiResponse(description = "Find Categories By VideoId", responseCode = "200")
    @Operation(summary = "Find By VideoId")
    public ResponseEntity<List<CategoryResponseDTO>> findByVideoId(@Valid @PathVariable("id") Long videoId) {
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findByVideoId(videoId)));
    }

    @GetMapping("/user/{id}/like-categories")
    @ApiResponse(description = "Find Liked Categories by User Id", responseCode = "200")
    @Operation(summary = "Find Liked Categories by User Id")
    public ResponseEntity<List<CategoryResponseDTO>> findLikedCategories(@Valid @PathVariable("id") Long userId) {
        return ResponseEntity.ok(mapper.toResponse(categoryUseCases.findUserLikedCategories(userId)));
    }

    @PostMapping("/user/{id}/like-categories")
    @ApiResponse(description = "Like Categories", responseCode = "200")
    @Operation(summary = "Like Categories")
    public ResponseEntity<Void> likeCategories(@Valid @PathVariable("id") Long userId,
                                               @Valid @RequestParam List<Long> categoryId) {
        log.info("Categories Ids {} requested to be liked by User ID {}", categoryId, userId);
        categoryUseCases.likeCategories(userId, categoryId);
        return ResponseEntity.ok().build();
    }
}
