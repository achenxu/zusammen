package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Voyage;

public interface VoyageRepository extends MongoRepository<Voyage, String> {
}
