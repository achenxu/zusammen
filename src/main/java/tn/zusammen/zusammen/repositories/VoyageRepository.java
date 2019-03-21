package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Localisation;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.entities.Voyage;

import java.util.List;

public interface VoyageRepository extends MongoRepository<Voyage, String> {

    List<Voyage> findVoyagesByEtatAndPrixBetweenAndTrajetContainsAndConducteur(
            String etat,
            Long prixMin,
            Long prixMax,
            Localisation localisation,
            User conducteur
    );

}
