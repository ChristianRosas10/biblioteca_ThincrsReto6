/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Horarios2;

/**
 *
 * @author christian
 */
@Local
public interface Horarios2FacadeLocal {

    void create(Horarios2 horarios2);

    void edit(Horarios2 horarios2);

    void remove(Horarios2 horarios2);

    Horarios2 find(Object id);

    List<Horarios2> findAll();

    List<Horarios2> findRange(int[] range);

    int count();
    
    List<Horarios2> buscarHorario(int idUsuario) throws Exception;
}
