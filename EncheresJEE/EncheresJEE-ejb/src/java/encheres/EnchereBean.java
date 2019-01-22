/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres;

import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import users.Utilisateur;

/**
 *
 * @author steve
 */
@Stateless (name = "enchere")
@LocalBean
public class EnchereBean implements Enchere{

    @Override
    public boolean encherir(Utilisateur user, int price, int idArticle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean winAuction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteEncherir(Utilisateur user, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewMyEnchere(Utilisateur user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
}
