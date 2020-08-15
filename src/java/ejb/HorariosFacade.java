/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Horarios;

/**
 *
 * @author christian
 */
@Stateless
public class HorariosFacade extends AbstractFacade<Horarios> implements HorariosFacadeLocal {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorariosFacade() {
        super(Horarios.class);
    }

    @Override
    public List<Horarios> buscarHorario(int idUsuario) throws Exception {
        List<Horarios> horario = null;
        String consulta;
        
        try{
            consulta = "FROM Horarios h WHERE h.id.id = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idUsuario);
            horario = query.getResultList();
        }catch(Exception e){
            throw e;
        }
        return horario;
    }
    
    

    
}
