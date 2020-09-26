package com.ambroziepaval.usermanager.service;

import com.ambroziepaval.usermanager.exception.UserNotFoundException;
import com.ambroziepaval.usermanager.model.User;

import java.util.List;

public interface UserService {

    /**
     * Get all users available in the database.
     *
     * @return List of users
     */
    List<User> getAllUsers();

    /**
     * Find User based on the username parameter.
     *
     * @param username Username String
     * @return user or null if there is no user with the given username
     */
    User getUserByUsername(String username) throws UserNotFoundException;
}
