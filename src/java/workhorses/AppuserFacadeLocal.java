/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workhorses;

import java.util.List;
import javax.ejb.Local;
import model.Appuser;

/**
 *
 * @author HP
 */
@Local
public interface AppuserFacadeLocal {

    void create(Appuser appuser);

    void edit(Appuser appuser);

    void remove(Appuser appuser);

    Appuser find(Object id);

    List<Appuser> findAll();

    List<Appuser> findRange(int[] range);

    int count();
    
}
