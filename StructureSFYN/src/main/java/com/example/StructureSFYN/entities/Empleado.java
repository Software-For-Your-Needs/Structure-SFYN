package com.example.StructureSFYN.entities;

import com.example.StructureSFYN.enums.Enum_RoleName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity//Se ingresa a la entidad Empleado
@Table(name= "Empleado")//Se asigna el nombre a la tabla de la clase Empleado
public class Empleado implements Serializable {

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Se define la PK llave primaria
    private Integer id;

    //Atributos
    @OneToOne
    private Profile profileEmpleado;
    @Column(name = "correoEmpleado")
    private String correoEmpleado;

    @Enumerated(EnumType.STRING)
    @Column(name = "rolEmpleado")
    private Enum_RoleName rolEmpleado;

    private Empresa empresaEmpleado;

    private MovimientoDinero transaccion;

    @Column(name = "updatedAt")
    private Date upDatedAt;

    @Column(name = "createdAt")
    private Date createdAt;

    // Método constructor
    public Empleado() {
    }

    public Empleado(Integer id, Profile profileEmpleado, String correoEmpleado, Enum_RoleName rolEmpleado, Empresa empresaEmpleado, MovimientoDinero transaccion, Date upDatedAt, Date createdAt) {
        this.id = id;
        this.profileEmpleado = profileEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.transaccion = transaccion;
        this.upDatedAt = upDatedAt;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profile getProfileEmpleado() {
        return profileEmpleado;
    }

    public void setProfileEmpleado(Profile profileEmpleado) {
        this.profileEmpleado = profileEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Enum_RoleName getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_RoleName rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public MovimientoDinero getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(MovimientoDinero transaccion) {
        this.transaccion = transaccion;
    }

    public Date getUpDatedAt() {
        return upDatedAt;
    }

    public void setUpDatedAt(Date upDatedAt) {
        this.upDatedAt = upDatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}