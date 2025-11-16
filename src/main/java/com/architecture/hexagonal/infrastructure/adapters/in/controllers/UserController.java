package com.architecture.hexagonal.infrastructure.adapters.in.controllers;

import com.architecture.hexagonal.application.services.UserService;
import com.architecture.hexagonal.domain.pojos.User;
import com.architecture.hexagonal.infrastructure.adapters.in.controllers.dto.UserDto;
import com.architecture.hexagonal.infrastructure.adapters.in.controllers.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDto> usersDto = users.stream().map(UserMapper::toUserDto).toList();
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(
            @PathVariable Long id
    ) {
        User user = userService.getUserById(id);
        if (user == null) return ResponseEntity.notFound().build();
        UserDto userDto = UserMapper.toUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
    ) {
        User user = UserMapper.toAppObject(userDto);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(UserMapper.toUserDto(createdUser));
    }

}
