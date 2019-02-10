package tn.zusammen.zusammen.services;

import tn.zusammen.zusammen.entities.Localisation;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.entities.Voyage;

import java.util.List;

public interface VoyageurService {

    List<Voyage> findVoyages(
            String etat,
            Long prixMin,
            Long prixMax,
            Localisation destination,
            User conducteur
    );

}
