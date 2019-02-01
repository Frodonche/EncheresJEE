/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import cookies.CookieGestion;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.Schedule;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import session.ArticlesFacade;
import session.EncheresFacade;
import session.PromotionsFacade;
import session.UsersFacade;

/**
 *
 * @author laura
 */
@Named(value = "promotions")
@RequestScoped
public class Promotions {
    
    @Inject
    PromotionsFacade promotions;
    
    public Promotions() {
    }
    
    public entity.Promotions getOne(){
        return promotions.findAll().get(0);
    }

    public entity.Promotions getTwo(){
        return promotions.findAll().get(1);
    }
    
    public entity.Promotions getThree(){
        return promotions.findAll().get(2);
    }
    
    @Schedule(hour="0")
    public void generatePromo(){
        promotions.remove(promotions.findAll().get(0));
        entity.Promotions tmp = getRandomPromo();
        promotions.create(tmp);
    }
    
    
    private entity.Promotions getRandomPromo(){
        int rand = (int) (Math.random() * ( 5 ));
        entity.Promotions tmp = new entity.Promotions();
        String promo = "";
        switch(rand){
            case 0 : promo = "20 % sur tout le site ! A partir de 200€ d'achat"; break;
            case 1 : promo = "Livraison offerte !" ; break;
            case 2 : promo = "10€ sur votre prochain achat ! A partir de 50€ d'achat";break;
            case 3 : promo = "30% sur la catégorie Electroménager" ; break;
            case 4 : promo = "5% de votre achat reversé à une association" ;break;
            
        }
        tmp.setNom(promo);
        return tmp;
    }
    
}
