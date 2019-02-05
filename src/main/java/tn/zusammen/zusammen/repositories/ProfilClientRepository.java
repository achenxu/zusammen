package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.ProfilClient;

public interface ProfilClientRepository extends MongoRepository<ProfilClient, String> {
}
