package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.ProfilVoyageur;

public interface ProfilVoyageurRepository extends MongoRepository<ProfilVoyageur, String> {
}
