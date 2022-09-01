package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "empleado")
public class Empleado implements Serializable{

    //Se agrega el @id
    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    //Atributos
    @Column(name= "nombreEmpleado")
    private String nombreEmpleado;

    @Column(name= "correoEmpleado")
    private String correoEmpleado;

    private enum rolEmpleado{
        Admin, Operario;}

    @Column(name= "idEmpleado")
    private int idEmpleado;

    @Column(name= "empresaEmpleado")
    private Empresa empresaEmpleado;

    // Método constructor


    public Empleado() {
    }
    public Empleado(int id, String nombreEmpleado, String correoEmpleado, int idEmpleado, Empresa empresaEmpleado) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.idEmpleado = idEmpleado;
        this.empresaEmpleado = empresaEmpleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }
}


