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
import modelo.Usuarios;

/**
 *
 * @author christian
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios iniciarSesion(Usuarios us){
        Usuarios usuario = null;
        String consulta;
        try{
            consulta = "FROM Usuarios u WHERE u.nombre = ?1 and u.password = ?2 and u.tipo = 'admin'";
            Query query = em.createQuery(consulta);
            query.setParameter(1,us.getNombre() );
            query.setParameter(2, us.getPassword());
            List<Usuarios> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }

    @Override
    public Usuarios iniciarSesion2(Usuarios us) {
        Usuarios usuario = null;
        String consulta;
        try{
            consulta = "FROM Usuarios u WHERE u.nombre = ?1 and u.password = ?2 and u.tipo = 'user'";
            Query query = em.createQuery(consulta);
            query.setParameter(1,us.getNombre() );
            query.setParameter(2, us.getPassword());
            List<Usuarios> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
}
