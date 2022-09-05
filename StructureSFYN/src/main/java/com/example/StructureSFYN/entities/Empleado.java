package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity//Se ingresa a la entidad Empleado
@Table(name= "Empleado")//Se asigna el nombre a la tabla de la clase Empleado
public class Empleado implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//Se define la PK llave primaria
    private int id;

    //Atributos
    @Column(name = "nombreEmpleado")//Se crea la primera columna de la tabla
    private String nombreEmpleado  = "carlos";
    @Column(name = "correoEmpleado")
    private String correoEmpleado;

    //@Column(name = "rolEmpleado")
    private enum rolEmpleado{
        Admin, Operario;}
    @Column(name = "idEmpleado")
    private Long idEmpleado;
    @Column(name = "empresaEmpleado")
    private Empresa empresaEmpleado;

    // Método constructor
    public Empleado() {
    }
    public Empleado(int id, String nombreEmpleado, String correoEmpleado, Long idEmpleado, Empresa empresaEmpleado) {
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

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }
}


