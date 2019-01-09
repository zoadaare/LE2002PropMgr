/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workhorses;

import java.util.List;
import javax.ejb.Local;
import model.Organization;

/**
 *
 * @author HP
 */
@Local
public interface OrganizationFacadeLocal {

    void create(Organization organization);

    void edit(Organization organization);

    void remove(Organization organization);

    Organization find(Object id);

    List<Organization> findAll();

    List<Organization> findRange(int[] range);

    int count();
    
}
