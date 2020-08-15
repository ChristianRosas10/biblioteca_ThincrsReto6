/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.Horarios2FacadeLocal;
import ejb.HorariosFacadeLocal;
import ejb.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Horarios;
import modelo.Horarios2;
import modelo.Usuarios;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class HorariosController implements Serializable {
    
    @EJB
    private HorariosFacadeLocal horarioEJB;
    private Horarios horarios;
    
    @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Usuarios usuarios;
    
    @EJB
    private Horarios2FacadeLocal horario2EJB;
    private Horarios2 horarios2;
    
    private List<Usuarios> nusuarios;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuarios> getNusuarios() {
        return nusuarios;
    }

    public void setNusuarios(List<Usuarios> nusuarios) {
        this.nusuarios = nusuarios;
    }
    
    @PostConstruct
    public void init(){
        usuarios = new Usuarios();
        horarios = new Horarios();
        horarios2 = new Horarios2();
       nusuarios = usuariosEJB.findAll();
    }
    
    public void entrada(){
        Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        horarios.setId(us);
        horarioEJB.create(horarios);
    }
    
    public void salida(){
        Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        horarios2.setId(us);
        horario2EJB.create(horarios2);
    }

    
}
