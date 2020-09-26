package com.ambroziepaval.usermanager.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("user")
public class User {

    @Id
    private ObjectId id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    private String username;

    private String email;

    @Field("job_title")
    private String jobTitle;

    private String race;

    private String gender;

    public User(String firstName, String lastName, String username, String email, String jobTitle, String race, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.jobTitle = jobTitle;
        this.race = race;
        this.gender = gender;
    }
}
