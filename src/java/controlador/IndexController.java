/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.UsuariosFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuarios;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class IndexController implements Serializable {
    
    @EJB
    private UsuariosFacadeLocal EJBUsuario;
    private Usuarios usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuarios();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        Usuarios us;
        String redireccionar = null ;
        try{
            us = EJBUsuario.iniciarSesion(usuario);
            if(us != null){
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                 redireccionar = "/protegido/principal?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas" ));
            }
           
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso", "Error"));
        }
        return redireccionar;
    }
    
        public String iniciarSesion2(){
        Usuarios us;
        String redireccionar = null ;
        try{
            us = EJBUsuario.iniciarSesion2(usuario);
            if(us != null){
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                 redireccionar = "/protegido/principal2?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas" ));
            }
           
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso", "Error"));
        }
        return redireccionar;
    }
}
