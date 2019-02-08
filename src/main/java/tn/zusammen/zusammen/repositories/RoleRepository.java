package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
}
