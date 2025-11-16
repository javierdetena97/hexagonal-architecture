package com.architecture.hexagonal.infrastructure.adapters.out.db.repositories;

import com.architecture.hexagonal.application.ports.UserRepository;
import com.architecture.hexagonal.domain.pojos.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserInMemoryRepositoryImpl implements UserRepository {

    public static Map<Long, User> users = new HashMap<>();

    public UserInMemoryRepositoryImpl() {
        users.put(1L, User.builder()
                .id(1L)
                .username("Javier de Tena")
                .email("javidetena@gmail.com")
                .build()
        );
    }

    @Override
    public List<User> getUsers() {
        return users.values().stream().toList();
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public User createUser(User user) {
        Long id = (long) users.size() + 1;
        user.setId(id);
        users.put(id, user);
        return user;
    }

}
