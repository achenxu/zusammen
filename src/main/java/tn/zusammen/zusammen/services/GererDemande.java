package tn.zusammen.zusammen.services;

import tn.zusammen.zusammen.entities.Demande;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.entities.Voyage;

public interface GererDemande {

    Demande ajouterVoyageur(Demande demande, Voyage voyage, User voyageur);

    void refuserVoyageur(Demande demande, Voyage voyage, String idVoyageur);

}
