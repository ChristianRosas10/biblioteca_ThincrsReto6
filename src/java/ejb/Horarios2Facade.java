/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public List<Horarios2> buscarHorario(int idUsuario) throws Exception {
        List<Horarios2> horario = null;
        String consulta;
        
        try{
            consulta = "FROM Horarios2 h WHERE h.id.id = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idUsuario);
            horario = query.getResultList();
        }catch(Exception e){
            throw e;
        }
        return horario;
    }
    
}
