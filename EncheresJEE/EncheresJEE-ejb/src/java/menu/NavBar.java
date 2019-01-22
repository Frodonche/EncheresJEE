/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author laura
 */
@Local
public interface NavBar { 
    public List<NavBarElement> getNavElementListDeconnecte();
    public List<NavBarElement> getNavElementListConnecte();
}
