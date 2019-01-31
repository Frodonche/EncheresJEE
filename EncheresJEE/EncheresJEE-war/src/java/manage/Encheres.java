/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import cookies.CookieGestion;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import session.ArticlesFacade;
import session.EncheresFacade;
import session.UsersFacade;

/**
 *
 * @author laura
 */
@Named(value = "encheres")
@RequestScoped
public class Encheres {
    
    @Inject
    EncheresFacade enchere;  
    @Inject
    UsersFacade utilisateur;
    @Inject
    ArticlesFacade article;
    
    
    public Encheres() {
    }
    
    public List<entity.Encheres> viewAllNotTerminated(){
        Date when = new java.sql.Date(System.currentTimeMillis());
        List<entity.Encheres> ret = new ArrayList<entity.Encheres>();
        Integer id = utilisateur.findByLogin(CookieGestion.getInstance().getCookie("login").getValue()).getId();
        for(entity.Encheres ench : enchere.findAll()){
            if(Objects.equals(ench.getIdUsers().getId(), id)){//si l'user correspond a l'enchere
                if(ench.getIdArticles().getDateFin().after(when))
                ret.add(ench);
            }
        }
        return ret;
    }
    
    public List<entity.Encheres> viewAllTerminated(){
        Date when = new java.sql.Date(System.currentTimeMillis());
        List<entity.Encheres> ret = new ArrayList<entity.Encheres>();
        Integer id = utilisateur.findByLogin(CookieGestion.getInstance().getCookie("login").getValue()).getId();
        for(entity.Encheres ench : enchere.findAll()){
            if(Objects.equals(ench.getIdUsers().getId(), id)){//si l'user correspond a l'enchere
                if(ench.getIdArticles().getDateFin().before(when))
                ret.add(ench);
            }
        }
        return ret;
    }
}
