package com.architecture.hexagonal.application.services;

import com.architecture.hexagonal.application.ports.UserRepository;
import com.architecture.hexagonal.application.usecases.users.CreateUser;
import com.architecture.hexagonal.application.usecases.users.GetUser;
import com.architecture.hexagonal.domain.pojos.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GetUser, CreateUser {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

}
