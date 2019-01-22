/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gugu
 */

@Stateless (name = "navbar")
@LocalBean
public class NavBarBean implements NavBar{
    
    @Override
    public List<NavBarElement> getNavElementListDeconnecte(){
        List<NavBarElement> list = new ArrayList<NavBarElement>();
        list.add(new NavBarElement("Accueil","index.xhtml"));
        list.add(new NavBarElement("Inscription","inscription.xhtml"));
        list.add(new NavBarElement("Voir les articles","listArticles.xhtml"));
        list.add(new NavBarElement("Connexion","login.xhtml"));
        return list;
    }
    
    @Override
    public List<NavBarElement> getNavElementListConnecte(){
        List<NavBarElement> list = new ArrayList<NavBarElement>();
        list.add(new NavBarElement("Accueil","index.xhtml"));
        list.add(new NavBarElement("Déposer un article","deposerArticle.xhtml"));
        list.add(new NavBarElement("Voir les articles","listArticles.xhtml"));
        return list;
    }
    
}
    
