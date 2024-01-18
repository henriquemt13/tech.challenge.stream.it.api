package com.tech.challenge.usecase;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.model.User;
import com.tech.challenge.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserUseCases {

    private final UserService userService;
    public User findById(Long userId) {
        var user = userService.findById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException(String.format("User ID %d not found", userId));
        }
        return user.get();
    }

    public Optional<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public User saveUser(User newUser) {
        if (findByUsername(newUser.getUsername()).isEmpty()) {
            return userService.save(newUser);
        }
        throw new BadRequestException(String.format("Username %s is already in use", newUser.getUsername()));
    }
}
