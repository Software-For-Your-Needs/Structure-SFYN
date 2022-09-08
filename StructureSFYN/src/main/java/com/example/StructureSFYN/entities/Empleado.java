package com.example.StructureSFYN.entities;

import com.example.StructureSFYN.enums.Enum_RoleName;
import java.util.Date;
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
    @Column(name = "profile")
    private Profile profile;
    @Column(name = "rol")
    private Enum_RoleName rol;

    @Column(name = "empresEmpleado")
    private Empresa empresaEmpleado;
    @Column(name = "transacciones")
    private List<MovimientoDinero> transacciones;
    @Column(name = "updateAt")
    private Date updatedAt;
    @Column(name = "createdAt")
    private Date createdAt;


    // Método Constructor

    public Empleado() {
    }

    public Empleado(int id, String nombreEmpleado, String correoEmpleado, com.example.StructureSFYN.entities.Profile profile, Enum_RoleName rol, com.example.StructureSFYN.entities.Empresa empresaEmpleado, List<MovimientoDinero> transacciones, Date updatedAt, Date createdAt) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.profile = profile;
        this.rol = rol;
        this.empresaEmpleado = empresaEmpleado;
        this.transacciones = transacciones;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    //Métodos Getter and Setter

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

    public com.example.StructureSFYN.entities.Profile getProfile() {
        return profile;
    }

    public void setProfile(com.example.StructureSFYN.entities.Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRol() {
        return rol;
    }

    public void setRol(Enum_RoleName rol) {
        this.rol = rol;
    }

    public com.example.StructureSFYN.entities.Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(com.example.StructureSFYN.entities.Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public List<MovimientoDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<MovimientoDinero> transacciones) {
        this.transacciones = transacciones;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}


