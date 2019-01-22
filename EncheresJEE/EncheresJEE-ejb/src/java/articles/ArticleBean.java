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
    public boolean addArticle(Utilisateur user, String name, String desc, int initPrice, String category, Date endDate) {
        try {
            String query = " insert into articles(ID_SELL_USERS,NOM,DESCRIPTION,PRIX_INIT,PRIX_MAX,DATE_FIN,VISIBLE,ID_BUY_USERS,NOM_CATEGORIE) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, user.getId(), name, desc, initPrice, initPrice, endDate, true , null, category);
            ResultSet rs = ps.executeQuery();
            rs.close();   
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyArticle(Utilisateur user, String name, String desc, int initPrice, String category, Date endDate) {
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
    public List<String> viewArticlesUserById(String id) {
        List<String> ret = new ArrayList<>(); ;
        try {
            String query = " Select * from articles where id_sell_users=?";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next() != false){
                ret.add(rs.getString(1) + "_" + rs.getString(2) + "_" + rs.getString(3) + "_" + rs.getString(4) + "_" + rs.getString(5) + "_" + rs.getString(6) + "_" + rs.getString(7) + "_" + rs.getString(8) + "_" + rs.getString(9));
            }
            rs.close();
            
        } catch (SQLException ex) {

        }
        return ret;
    }
    
    @Override
    public String viewNameUserById(String id) {
        String name = "";
        try {
            String query = " Select nom from users where id=?";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next() != false){
                name = rs.getString(1);
            }
            rs.close();
            
        } catch (SQLException ex) {

        }
        return name;
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
        try {
            String query = " Select * from articles where visible=?";
            PreparedStatement ps = BDDConnection.getInstance().initialisationRequetePreparee(con, query, "true");
            ResultSet rs = ps.executeQuery();
            while(rs.next() != false){
                ret.add(rs.getString(1) + "_" + rs.getString(2) + "_" + rs.getString(3) + "_" + rs.getString(4) + "_" + rs.getString(5) + "_" + rs.getString(6) + "_" + rs.getString(7) + "_" + rs.getString(8) + "_" + rs.getString(9));
            }
            rs.close();
            
        } catch (SQLException ex) {

        }
        return ret;
    }
}
