/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import entity.Encheres;
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
@Named(value = "encherir")
@RequestScoped
public class Encherir {
    
    @Inject
    EncheresFacade enchere;  
    @Inject
    UsersFacade utilisateur;
    @Inject
    ArticlesFacade article;
    
    Encheres enchereActif;
    private String value;
    
    public Encherir(){
        this.value = "0";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
        
    public String encherir(String id, String idBuy){
        entity.Encheres encTmp = new entity.Encheres();
        encTmp.setIdArticles(article.find(Integer.parseInt(id)));
        encTmp.setIdUsers(utilisateur.find(Integer.parseInt(idBuy)));
        encTmp.setValue(Integer.parseInt(this.value));
        enchere.create(encTmp);
        return "listArticles?faces-redirect=true";
    }
    
}
