package com.ambroziepaval.usermanager.rest.v1;

import com.ambroziepaval.usermanager.exception.UserNotFoundException;
import com.ambroziepaval.usermanager.model.User;
import com.ambroziepaval.usermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {

        log.info("GET /users REST Request called.");

        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws UserNotFoundException {

        log.info("GET /users/{} REST Request called.", username);

        return userService.getUserByUsername(username);
    }
}
