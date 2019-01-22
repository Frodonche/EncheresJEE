/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

/**
 *
 * @author laura
 */
public class ArticleDef {
    
    private String id;
    private String id_sell_users;
    private String id_buy_users;
    private String nom;
    private String description;
    private String prix_init;
    private String prix_max;
    private String visible;
    
    public ArticleDef(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9){
        this.id = s1;
        this.id_sell_users = s2;
        this.id_buy_users = s3;
        this.nom = s4;
        this.description = s5;
        this.prix_init = s6;
        this.prix_max = s7;
        this.visible = s8;
    }
    
    public String getId(){
        return this.id;
    } 
        
    public String getId_sell_users(){
        return this.id_sell_users;
    } 
    
    public String getId_buy_users(){
        return this.id_buy_users;
    }
    
    public String getNom(){
        return this.nom;
    }

    public String getDescription(){
        return this.description;
    }
    
    public String getPrix_init(){
        return this.prix_init;
    }
    
    public String getPrix_max(){
        return this.prix_max;
    }
    
    public String getVisible(){
        return this.visible;
    }
}

