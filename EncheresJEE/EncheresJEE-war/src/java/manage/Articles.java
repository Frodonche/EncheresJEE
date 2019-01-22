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
 * @author laura
 */
@Named(value = "articles")
@RequestScoped
public class Articles {

    @Inject 
    ArticleBean article;

    public Articles() {     
        
    }
    
    public List<ArticleDef> viewAll(){
        List<ArticleDef> res = new ArrayList();
        List<String> tmp = article.viewAll();
        String[] tstmp;
        String stmp;
        for(String s : tmp){
            tstmp = s.split("_");
            
            res.add(new ArticleDef(tstmp[0], tstmp[1], tstmp[2], tstmp[3], tstmp[4], tstmp[5], tstmp[6], tstmp[7], tstmp[8]));
        }
        return res;
    }
    public List<String> getCat(){
        return article.getAllCategory();
    }
    public List<String> getSsCat(){
        return article.getAllSsCategory();
    }
    
    public String viewNameUserById(String id){
        return article.viewNameUserById(id);
    }
    
}