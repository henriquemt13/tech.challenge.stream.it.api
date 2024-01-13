package com.tech.challenge.controller.v1;

import com.tech.challenge.dto.request.UserRequestDTO;
import com.tech.challenge.dto.response.CategoryResponseDTO;
import com.tech.challenge.dto.response.UserResponseDTO;
import com.tech.challenge.mapper.CategoryMapper;
import com.tech.challenge.mapper.UserMapper;
import com.tech.challenge.usecase.UserUseCases;
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
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User")
public class UserController {

    private UserUseCases userUseCases;
    private UserMapper userMapper;
    private CategoryMapper categoryMapper;

    @GetMapping("/{id}")
    @ApiResponse(description = "Get User", responseCode = "200")
    @Operation(summary = "Get User by UserId")
    public ResponseEntity<UserResponseDTO> findById(@Valid @PathVariable Long userId) {
        return ResponseEntity.ok(userMapper.toResponse(userUseCases.findById(userId)));
    }


    @PostMapping("")
    @ApiResponse(description = "Save User", responseCode = "200")
    @Operation(summary = "Save User")
    public ResponseEntity<UserResponseDTO> save(@Valid @ParameterObject UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userMapper.toResponse(userUseCases.saveUser(userMapper.createRequestToDomain(userRequestDTO))));
    }
}
