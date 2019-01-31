/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author laura
 */
@Named(value = "encherir")
@RequestScoped
public class Encherir {
    
    public Encherir(){
        
    }
    
    
    
    public String encherir(){
        return "TODO";
    }
    
}
