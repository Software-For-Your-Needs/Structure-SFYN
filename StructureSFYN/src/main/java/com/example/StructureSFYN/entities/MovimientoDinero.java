package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Movimiento Dinero")
public class MovimientoDinero implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    // Atributos
    @Column (name = "Concepto")
    private String concepto;
    @Column(name = "Montos")
    private Float monto;
    @Column(name = "Empleado")
    private Empleado empleado;
    @Column (name = "Empresa")
    private Empresa empresa;
    @Column (name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;
    // Método constructor


    public MovimientoDinero() {
    }

    public MovimientoDinero(Integer id, String concepto, Float monto, Empleado empleado, Empresa empresa, Date createdAt, Date updatedAt) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

