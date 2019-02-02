package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="demandes")
public class Demande {

    @Id
    private String etat;

    private List<Voyage> voyages;
    private List<User> users;

    public Demande(String etat, List<Voyage> voyages, List<User> users) {
        this.etat = etat;
        this.voyages = voyages;
        this.users = users;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
