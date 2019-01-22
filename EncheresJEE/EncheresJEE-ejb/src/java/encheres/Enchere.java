/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres;

import javax.ejb.Local;
import users.Utilisateur;

/**
 *
 * @author laura
 */
@Local
public interface Enchere { 

    //generation d'un id pour l'enchere
    public boolean encherir(Utilisateur user, int price, int idArticle);
    
    //met a jour la liste des encheres gagnées
    public boolean winAuction();
    
    //ne pas oublier d'incrementer le compteur des encheres abandonnées
    public boolean deleteEncherir(Utilisateur user, int id);
    
    public String viewMyEnchere(Utilisateur user);
    
}
