/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import articles.ArticleBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laura
 */
@Named(value = "depos")
@RequestScoped
public class DeposerArticle {
    
    @Inject 
    ArticleBean article;
    
    private String idSellUsers;
    private String idBuyUsers;
    private String nom;
    private String description;
    private String prixInit;
    private String dateFin;
    private String prixMax;
    private String visible;
    
    public DeposerArticle(){
        this.idSellUsers = "null";
        this.idBuyUsers = "null";
        this.nom = "Sans titre";
        this.description = "Sans titre";
        this.prixInit = "0";
        this.dateFin = "01-01-2042";
        this.prixMax = "null";
        this.visible = "true";
    }
    
    public String getIdSellUsers(){
        return this.idSellUsers;
    }
    
    public String getIdBuyUsers(){
        return this.idBuyUsers;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getPrixInit(){
        return this.prixInit;
    }
    
    public String getDateFin(){
        return this.dateFin;
    }
    
    public String getPrixMax(){
        return this.prixMax;
    }
    
    public String getVisible(){
        return this.visible;
    }
    
    public void setIdSellUsers(String id){
        this.idSellUsers = id;
    }
    
    public void setIdBuyUsers(String id){
        this.idBuyUsers = id;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    
    public void setPrixInit(String p){
        this.prixInit = p;
    }
    
    public void setDateFin(String d){
        this.dateFin = d;
    }

    public void setPrixMax(String p){
        this.prixMax = p;
    }
    
    public void setVisible(String v){
        this.visible = v;
    }
    
    public String validationDepos(){
        return "TODO";
    }
}
