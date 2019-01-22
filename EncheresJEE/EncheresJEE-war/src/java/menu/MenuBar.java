/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cirstea
 */
@Named(value = "menubar")
@RequestScoped
public class MenuBar {

    @Inject 
    NavBarBean navBar;

    public MenuBar() {        
    }
   
    public List<NavBarElement> getNavBarConnecte(){
        List<NavBarElement> list = navBar.getNavElementListConnecte();    
        return list;
    }
    
    public List<NavBarElement> getNavBarDeconnecte(){
        List<NavBarElement> list = navBar.getNavElementListDeconnecte();  
        return list;
    }
    
}