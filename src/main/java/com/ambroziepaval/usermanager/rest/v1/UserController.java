package com.ambroziepaval.usermanager.rest.v1;

import com.ambroziepaval.usermanager.model.User;
import com.ambroziepaval.usermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getAllUsers();
    }
}
