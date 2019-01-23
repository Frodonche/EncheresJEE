/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Encheres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author laura
 */
@Stateless
public class EncheresFacade extends AbstractFacade<Encheres>{
    
    @PersistenceContext(unitName = "EncheresJEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncheresFacade() {
        super(Encheres.class);
    }
    
}
