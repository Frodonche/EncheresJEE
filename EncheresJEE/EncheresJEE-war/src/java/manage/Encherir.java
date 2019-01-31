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
    private String valeurActuelle;
    
    public Encherir() {
        this.valeurActuelle = "0";
    }

    public String getValeurActuelle() {
        System.out.println("ENTER GET VALUEEEEEEEEEEE");
        return valeurActuelle;
    }

    public void setValeurActuelle(String valeurActuelle) {
        System.out.println("ENTER SET VALUEEEEEEEEEEE");
        this.valeurActuelle = valeurActuelle;
    }
        
    public String encherir(String id, String idBuy){
        entity.Encheres encTmp = new entity.Encheres();
        encTmp.setIdArticles(article.find(Integer.parseInt(id)));
        encTmp.setIdUsers(utilisateur.find(Integer.parseInt(idBuy)));
        System.out.println("VALEURACTUELLE   " + this.valeurActuelle);
        encTmp.setValue(Integer.parseInt(this.valeurActuelle));
        enchere.create(encTmp);
        return "listArticles?faces-redirect=true";
    }
    
}
