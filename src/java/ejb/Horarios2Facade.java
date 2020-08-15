/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Horarios2;

/**
 *
 * @author christian
 */
@Stateless
public class Horarios2Facade extends AbstractFacade<Horarios2> implements Horarios2FacadeLocal {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Horarios2Facade() {
        super(Horarios2.class);
    }
    
}
