package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.ProfilConducteur;

public interface ProfilConducteurRepository extends MongoRepository<ProfilConducteur, String> {
}
