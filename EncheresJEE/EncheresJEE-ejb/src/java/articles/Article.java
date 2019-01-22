/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articles;

import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import users.Utilisateur;

/**
 *
 * @author laura
 */
@Local
public interface Article { 
    //attention a bien generer un id unique
    public boolean addArticle(Utilisateur user, String name, String desc, int initPrice, String category, Date endDate);
    
    //Possible uniquement si la date endDate est passée, CAD article n'est plus en vente.
    public boolean modifyArticle(Utilisateur user, String name, String desc, int initPrice, String category, Date endDate);
    
    public boolean deleteArticle(Utilisateur user);
    
    public String viewArticle(Utilisateur user);
    
    public List<String> viewAll();
    
    public String viewArticleByCategory(String cat);
    
    public List<String> viewArticlesUserById(String id);
    
    public String viewNameUserById(String id);
    
    public List<String> getAllCategory();
   
    public List<String> getAllSsCategory();

    public List<String> generationPromotion();
    
}
