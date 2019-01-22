/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import javax.ejb.Local;

/**
 *
 * @author laura
 */
@Local
public interface Utilisateur { 
    
    public String inscrire(String login, 
            String pass,
            String nom, 
            String prenom, 
            String adresse,
            String id_bancaire,
            boolean connecte,
            int nb_abandon);
    
    public boolean connecter(String login, String pass);
    
    public String getLogin();

    public void setLogin(String login);

    public String getPass();

    public void setPass(String pass);

    public String getNom();

    public void setNom(String nom);

    public String getPrenom();

    public void setPrenom(String prenom);

    public String getAdresse();

    public void setAdresse(String adresse);

    public String getId_bancaire();

    public void setId_bancaire(String id_bancaire);

    public boolean isConnecte();

    public void setConnecte(boolean connecte);

    public int getNb_abandon();

    public void setNb_abandon(int nb_abandon);
    
    public int getId();
}
