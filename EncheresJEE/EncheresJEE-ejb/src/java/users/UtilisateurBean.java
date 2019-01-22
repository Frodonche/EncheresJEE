/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import bdd.BDDConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gugu
 */

@Stateless (name = "utilisateur")
@LocalBean
public class UtilisateurBean implements Utilisateur{

    String login; 
    String pass;
    String nom; 
    String prenom; 
    String adresse;
    String id_bancaire;
    boolean connecte;
    int nb_abandon;

    public UtilisateurBean(){}
    
    public String inscrire(String login, 
            String pass,
            String nom, 
            String prenom, 
            String adresse,
            String id_bancaire,
            boolean connecte,
            int nb_abandon){ 
        this.login = login ; 
        this.pass = pass ;
        this.nom = nom ; 
        this.prenom = prenom ; 
        this.adresse = adresse ;
        this.id_bancaire = id_bancaire ;
        this.connecte = connecte ;
        this.nb_abandon = nb_abandon ;
        
        String requeteSQL = "INSERT INTO users (login, pass, nom, prenom, adresse, id_bancaire, connecte, nb_abandon) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
        Object[] objets = {getLogin(),getPass(),getNom(),getPrenom(),getAdresse(),getId_bancaire(),isConnecte(),getNb_abandon()};
        try {
            BDDConnection bdd = BDDConnection.getInstance();
            PreparedStatement ps = bdd.initialisationRequetePreparee( bdd.getConnection() , requeteSQL , objets);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BDDConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Utilisateur "+ login + " inscrit !";
    }    
    
    public boolean connecter(String login, String pass){
        
        // @TODO : faire la connection avec la BDD
        // return true si l'utilisateur est bien dans la bdd avec bon mdp
        // false sinon
        
        String requeteSQL = "SELECT login, pass FROM users WHERE login = ? and pass = ?";
        Object[] objets = {login, pass};
        try {
            BDDConnection bdd = BDDConnection.getInstance();
            PreparedStatement ps = bdd.initialisationRequetePreparee( bdd.getConnection() , requeteSQL , objets);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BDDConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return false;
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

}
