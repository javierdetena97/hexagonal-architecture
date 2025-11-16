package com.architecture.hexagonal.application.ports;

import com.architecture.hexagonal.domain.pojos.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUserById(Long id);

    User createUser(User user);

}
