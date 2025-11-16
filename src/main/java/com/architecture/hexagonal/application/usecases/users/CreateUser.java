package com.architecture.hexagonal.application.usecases.users;

import com.architecture.hexagonal.domain.pojos.User;

public interface CreateUser {

    User createUser(User user);

}
