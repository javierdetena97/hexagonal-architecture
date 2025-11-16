package com.architecture.hexagonal.application.usecases.users;

import com.architecture.hexagonal.domain.pojos.User;

import java.util.List;

public interface GetUser {

    List<User> getUsers();

    User getUserById(Long id);

}
