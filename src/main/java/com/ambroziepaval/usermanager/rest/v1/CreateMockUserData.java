package com.ambroziepaval.usermanager.rest.v1;

import com.ambroziepaval.usermanager.model.User;
import com.ambroziepaval.usermanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CreateMockUserData {

    @Value("classpath:static/users.csv")
    private Resource userResourceFile;

    private final UserRepository userRepository;

    @PostMapping("/mock/users")
    public void resetUserData() {

        log.info("POST /mock/users REST Request called.");

        try {
            List<User> users = getUsersFromFile();
            userRepository.insert(users);

        } catch (IOException e) {
            log.error("Error saving the mock user data.", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users .csv file not found");
        }
    }

    /**
     * Read all the user information provided in the .csv resource file.
     * Format: first_name,last_name,email,job_title,race,gender
     *
     * @return all the user information mapped directly to the model class User
     * @throws IOException IO Exception on the users.csv file
     */
    private List<User> getUsersFromFile() throws IOException {
        List<User> userList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(userResourceFile.getInputStream()));

        String line = bufferedReader.readLine();
        while (Objects.nonNull(line)) {

            String[] userElements = line.split(",");
            userList.add(new User(userElements[0], userElements[1], userElements[2], userElements[3], userElements[4], userElements[5]));

            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return userList;
    }
}
