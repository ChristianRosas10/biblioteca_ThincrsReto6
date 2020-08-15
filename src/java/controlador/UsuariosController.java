/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuarios;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class UsuariosController implements Serializable {
    
    @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Usuarios usuarios;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    @PostConstruct
    public void init(){
        this.usuarios = new Usuarios();
    }
    
    public void registrar(){
        try{
            this.usuariosEJB.create(usuarios);
            this.usuarios = new Usuarios();
        }catch(Exception e){
            //mensaje prime grwol
        }
    }
    
    public List<Usuarios> lista(){
        return this.usuariosEJB.findAll();
    }
    
    public void delete(Usuarios usuarios){
        this.usuariosEJB.remove(usuarios);
    }
    
    public void editar(Usuarios p){
      usuarios = p;
      
    }
    
    public void editar(){
     usuariosEJB.edit(usuarios);
    
    }
    
    
    
    
}
