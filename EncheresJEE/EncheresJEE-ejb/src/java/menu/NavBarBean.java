/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import users.*;
import bdd.BDDConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gugu
 */

@Stateless (name = "navbar")
@LocalBean
public class NavBarBean implements NavBar{
    
    public List<NavBarElement> getNavElementListDeconnecte(){
        List<NavBarElement> list = new ArrayList<NavBarElement>();
        list.add(new NavBarElement("Accueil","index.xhtml"));
        list.add(new NavBarElement("Inscription","inscription.xhtml"));
        list.add(new NavBarElement("Voir les articles","listArticles.xhtml"));
        list.add(new NavBarElement("Connexion","login.xhtml"));
        return list;
    }
    
    public List<NavBarElement> getNavElementListConnecte(){
        List<NavBarElement> list = new ArrayList<NavBarElement>();
        list.add(new NavBarElement("Accueil","index.xhtml"));
        list.add(new NavBarElement("Déposer un article","deposerArticle.xhtml"));
        list.add(new NavBarElement("Voir les articles","listArticles.xhtml"));
        //list.add(new NavBarElement("#{sessionScope.username}","", new NavBarElement("Mes enchères", "encheres.xhtml")));
        //list.add(new NavBarElement("Deconnexion","#{connection.deconnecter()}"));
        return list;
    }
    
}
    
