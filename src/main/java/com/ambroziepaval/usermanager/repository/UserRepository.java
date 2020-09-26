package com.ambroziepaval.usermanager.repository;

import com.ambroziepaval.usermanager.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{'user_name' : ?0}")
    Optional<User> findByUsername(String username);
}
