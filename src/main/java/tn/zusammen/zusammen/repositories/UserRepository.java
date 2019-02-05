package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
}
