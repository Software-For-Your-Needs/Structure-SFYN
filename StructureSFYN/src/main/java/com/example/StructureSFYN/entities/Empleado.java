package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;

public class Empleado implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    //Atributos
    private String nombreEmpleado;
    private String correoEmpleado;
    private enum rolEmpleado{
        Admin, Operario;}
    private int idEmpleado;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


