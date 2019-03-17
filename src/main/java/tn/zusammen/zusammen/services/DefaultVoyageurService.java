package tn.zusammen.zusammen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.zusammen.zusammen.entities.Localisation;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.entities.Voyage;
import tn.zusammen.zusammen.repositories.VoyageRepository;

import java.util.List;

@Service
public class DefaultVoyageurService implements VoyageurService {

    @Autowired
    private VoyageRepository voyageRepository;

    @Override
    public List<Voyage> findVoyages(String etat, Long prixMin, Long prixMax, Localisation destination, User conducteur) {
        return voyageRepository.findVoyagesByEtatAndPrixBetweenAndTrajetContainsAndConducteur(
                etat,
                prixMin,
                prixMax,
                destination,
                conducteur
        );
    }

}
