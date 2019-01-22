/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import articles.Article;
import articles.ArticleBean;
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
    ArticleBean article;

    public Articles() {        
    }
    public List<String> viewAll(){
        List<String> res = article.viewAll();
        List<String> tmp = article.viewAll();
        for(String s : tmp){
            System.out.println(s);
        }
        return res;
    }
    public List<String> getCat(){
        return article.getAllCategory();
    }
    public List<String> getSsCat(){
        return article.getAllSsCategory();
    }
    
}