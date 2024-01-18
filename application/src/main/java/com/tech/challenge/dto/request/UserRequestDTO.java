package com.tech.challenge.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotNull(message = "username should not be null")
    @NotEmpty(message = "username should not be empty")
    private String username;
}
