/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import entity.Articles;
import session.ArticlesFacade;
import session.CategoriesFacade;
import session.EncheresFacade;
import session.UsersFacade;

/**
 *
 * @author laura
 */
@Named(value = "supprimer")
@RequestScoped
public class SupprimerArticle {
    
    @Inject 
    ArticlesFacade article;
    @Inject 
    EncheresFacade enchere;
    @Inject 
    CategoriesFacade categorie;
    
    Articles articleActif;
    
    public SupprimerArticle(){

    }
    
    public String supprimerArticle(String id){
        
                //enchere.remove(enchere.find(Integer.parseInt(id)));
        //article.remove(article.find(Integer.parseInt(id)));
        return "mesArticles.xhtml";
    }
}
