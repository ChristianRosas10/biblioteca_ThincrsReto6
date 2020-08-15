/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "horarios2")
public class Horarios2 implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_horario2;
    
    @ManyToOne
    @JoinColumn(name = "id")
    private Usuarios id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "salida", insertable = false)
    private Date salida;

    public int getId_horario2() {
        return id_horario2;
    }

    public void setId_horario2(int id_horario2) {
        this.id_horario2 = id_horario2;
    }

    public Usuarios getId() {
        return id;
    }

    public void setId(Usuarios id) {
        this.id = id;
    }


    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }
    
    
}
