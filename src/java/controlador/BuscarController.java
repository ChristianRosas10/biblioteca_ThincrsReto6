/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.HorariosFacadeLocal;
import ejb.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Horarios;
import modelo.Usuarios;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class BuscarController implements Serializable {

       @EJB
       private UsuariosFacadeLocal usuariosEJB;
       
       @EJB
       private HorariosFacadeLocal horariosEJB;
       
       private List<Usuarios> nusuarios;
       private List<Horarios> nhorarios;
       
       private int codigoUsuario;

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
       
       

    public List<Usuarios> getNusuarios() {
        return nusuarios;
    }

    public void setNusuarios(List<Usuarios> nusuarios) {
        this.nusuarios = nusuarios;
    }

    public List<Horarios> getNhorarios() {
        return nhorarios;
    }

    public void setNhorarios(List<Horarios> nhorarios) {
        this.nhorarios = nhorarios;
    }
       
    
        
       @PostConstruct
       public void init(){
           nusuarios = usuariosEJB.findAll();
       }
       
       public void buscarHorario() throws Exception{
           try{
            nhorarios =  horariosEJB.buscarHorario(codigoUsuario);
           }catch(Exception e){
               throw e;
           }
       }
}
