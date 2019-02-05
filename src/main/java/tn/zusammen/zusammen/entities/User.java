package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {

    @Id
    private String email;

    private String nom;
    private String prenom;
    private String adresse;
    private ProfilClient profilClient;
    private ProfilVoyageur profilVoyageur;
    private ProfilConducteur profilConducteur;
    private String mdp;
    private Boolean activated;
    private Role role;
    private String cin;

    public User() {
    }

    public User(String email, String mdp, Role role) {
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    public User(String cin, String nom, String prenom, String adresse, ProfilClient profilClient, ProfilVoyageur profilVoyageur, ProfilConducteur profilConducteur, String email, String mdp, Boolean activated, Role role) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.profilClient = profilClient;
        this.profilVoyageur = profilVoyageur;
        this.profilConducteur = profilConducteur;
        this.email = email;
        this.mdp = mdp;
        this.activated = activated;
        this.role = role;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ProfilClient getProfilClient() {
        return profilClient;
    }

    public void setProfilClient(ProfilClient profilClient) {
        this.profilClient = profilClient;
    }

    public ProfilVoyageur getProfilVoyageur() {
        return profilVoyageur;
    }

    public void setProfilVoyageur(ProfilVoyageur profilVoyageur) {
        this.profilVoyageur = profilVoyageur;
    }

    public ProfilConducteur getProfilConducteur() {
        return profilConducteur;
    }

    public void setProfilConducteur(ProfilConducteur profilConducteur) {
        this.profilConducteur = profilConducteur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
