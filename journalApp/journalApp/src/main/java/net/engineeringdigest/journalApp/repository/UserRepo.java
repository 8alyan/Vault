package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByusername(String user);

    void deleteByusername(String username);
}
