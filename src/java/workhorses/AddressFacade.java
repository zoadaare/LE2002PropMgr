/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workhorses;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Address;

/**
 *
 * @author HP
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> implements AddressFacadeLocal {

    @PersistenceContext(unitName = "LE2002PropMgrPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }
    
}
