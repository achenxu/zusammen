package tn.zusammen.zusammen.services;

import tn.zusammen.zusammen.entities.Voyage;

import java.util.List;

public interface GererPropVoyMetier {

    Voyage ajouterTrajet(Voyage voyage);

    void annulerTrajet(String id);

    List<Voyage> listPropositions();

    Voyage majTrajet(Voyage voyage);

}
