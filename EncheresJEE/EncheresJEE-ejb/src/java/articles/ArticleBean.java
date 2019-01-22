/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articles;

import bdd.BDDConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import users.Utilisateur;

/**
 *
 * @author gugu
 */

@Stateless (name = "article")
@LocalBean
public class ArticleBean implements Article{
    
    private Connection con;

    public ArticleBean(){
        try {   
            con = BDDConnection.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean addArticle(Utilisateur user, String name, String desc, int initPrice, List<String> category, Date endDate) {
        try {
            String query = " insert into  * from articles where visible=?";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, "true");
            ResultSet rs = ps.executeQuery();
            while(rs.next() != false){
                ret.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) + " " + rs.getString(9));
            }
            rs.close();
            
        } catch (SQLException ex) {

        }
        return true;
    }

    @Override
    public boolean modifyArticle(Utilisateur user, String name, String desc, int initPrice, List<String> category, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteArticle(Utilisateur user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewArticle(Utilisateur user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewArticleByCategory(String cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewArticleByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<String> getAllSsCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<String> generationPromotion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> viewAll() {
        List<String> ret = new ArrayList<>(); ;
        //ret.add("nom : article1 , description : ceci est l'article 1 , prix_depart : 50 , date_fin : 12/12/19 , prix_actuel : 65 ,visible : 1 , id : 123");
        try {
            String query = " Select * from articles where visible=?";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, "true");
            ResultSet rs = ps.executeQuery();
            while(rs.next() != false){
                ret.add(rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7) + "-" + rs.getString(8) + "-" + rs.getString(9));
            }
            rs.close();
            
        } catch (SQLException ex) {

        }
        return ret;
    }

}
