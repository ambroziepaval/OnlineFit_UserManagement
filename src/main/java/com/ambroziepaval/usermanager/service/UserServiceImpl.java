package com.ambroziepaval.usermanager.service;

import java.util.List;
import java.util.Optional;

import com.ambroziepaval.usermanager.exception.UserNotFoundException;
import com.ambroziepaval.usermanager.model.User;
import com.ambroziepaval.usermanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            log.error("User with username: {} not found", username);
            throw new UserNotFoundException();
        }

        return user.get();
    }
}
