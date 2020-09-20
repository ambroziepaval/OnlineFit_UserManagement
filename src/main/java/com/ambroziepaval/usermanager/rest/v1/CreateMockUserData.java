package com.ambroziepaval.usermanager.rest.v1;

import com.ambroziepaval.usermanager.model.User;
import com.ambroziepaval.usermanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CreateMockUserData {

    private final UserRepository userRepository;

    @PostMapping("/mock/users")
    public void resetUserData() {

        try {
            List<User> users = getUsersFromFile();
            userRepository.insert(users);

        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users .csv file not found", e);
        }
    }

    private List<User> getUsersFromFile() throws IOException {
        List<User> userList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(loadUserMockFile()));

        String line = bufferedReader.readLine();
        while (Objects.nonNull(line)) {


            String[] userElements = line.split(",");
            userList.add(new User(userElements[0], userElements[1], userElements[2], userElements[3], userElements[4], userElements[5]));


            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return userList;
    }

    private File loadUserMockFile() throws FileNotFoundException {

        // csv User format: first_name,last_name,email,job_title,race,gender
        return ResourceUtils.getFile("classpath:static/users.csv");
    }
}
