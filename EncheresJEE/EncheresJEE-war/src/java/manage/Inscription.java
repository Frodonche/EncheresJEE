/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import users.Utilisateur;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cirstea
 */
@Named(value = "inscription")
@RequestScoped
public class Inscription {

    @Inject 
    Utilisateur utilisateur;

    private String login;
    private String pass;
    private String nom;
    private String prenom;
    private String adresse;
    private String id_bancaire;
    private boolean connecte;
    private int nb_abandon;
   
    
    /**
     * Creates a new instance of Hello
     */
    public Inscription() {
        login = "default";
        pass = "default";
        nom = "default";
        prenom = "default";
        adresse = "default";
        id_bancaire = "default";
        connecte = false;
        nb_abandon = 0;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getId_bancaire() {
        return id_bancaire;
    }

    public void setId_bancaire(String id_bancaire) {
        this.id_bancaire = id_bancaire;
    }

    public boolean isConnecte() {
        return connecte;
    }

    public void setConnecte(boolean connecte) {
        this.connecte = connecte;
    }

    public int getNb_abandon() {
        return nb_abandon;
    }

    public void setNb_abandon(int nb_abandon) {
        this.nb_abandon = nb_abandon;
    }

    
    public String inscrire() { // TODO : faire fonction qui renvoie l'utilisateur depuis la BDD
        return utilisateur.inscrire(login, pass, nom, prenom, adresse, id_bancaire, connecte, nb_abandon);  
    }
    
}