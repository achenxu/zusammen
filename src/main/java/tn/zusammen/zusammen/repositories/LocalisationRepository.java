package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Localisation;

public interface LocalisationRepository extends MongoRepository<Localisation, String> {
}
