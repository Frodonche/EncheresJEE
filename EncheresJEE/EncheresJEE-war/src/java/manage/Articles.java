/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import articles.Article;
import java.util.ArrayList;
import java.util.List;
import users.Utilisateur;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cirstea
 */
@Named(value = "articles")
@RequestScoped
public class Articles {

    @Inject 
    Article article;

    private List<String> cat, ssCat;
    private List<String> articles;
      
    public Articles() {
        articles = new ArrayList<String>();
        cat = new ArrayList<String>();
        ssCat = new ArrayList<String>();
        articles = article.viewAll();
        cat = article.getAllCategory();
        ssCat = article.getAllSsCategory();
    }
    public List<String> viewAll(){
        return articles;
    }
    public List<String> getCat(){
        return cat;
    }
    public List<String> getSsCat(){
        return ssCat;
    }
    
}