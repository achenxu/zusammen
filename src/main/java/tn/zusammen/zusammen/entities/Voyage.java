package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Voyage {

    @Id
    private String id;

    private String etat;
    private Long prix;
    private List<Localisation> trajet;
    private User conducteur;
    private Long nbrePlaceRest;

    public Voyage(String id, String etat, Long prix, List<Localisation> trajet, User conducteur) {
        this.id = id;
        this.etat = etat;
        this.prix = prix;
        this.trajet = trajet;
        this.conducteur = conducteur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public List<Localisation> getTrajet() {
        return trajet;
    }

    public void setTrajet(List<Localisation> trajet) {
        this.trajet = trajet;
    }

    public User getConducteur() {
        return conducteur;
    }

    public void setConducteur(User conducteur) {
        this.conducteur = conducteur;
    }

    public Long getNbrePlaceRest() {
        return nbrePlaceRest;
    }

    public void setNbrePlaceRest(Long nbrePlaceRest) {
        this.nbrePlaceRest = nbrePlaceRest;
    }

}
