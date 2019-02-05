package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Demande;

public interface DemandeRepository extends MongoRepository<Demande, String> {
}
