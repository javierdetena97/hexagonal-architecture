package com.architecture.hexagonal.infrastructure.adapters.in.controllers.mapper;

import com.architecture.hexagonal.domain.pojos.User;
import com.architecture.hexagonal.infrastructure.adapters.in.controllers.dto.UserDto;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public static User toAppObject(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .build();
    }

}
