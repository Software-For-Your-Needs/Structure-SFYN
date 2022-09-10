package com.example.StructureSFYN.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaccion")
public class MovimientoDinero implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    // Atributos
    @Column (name = "Concepto")
    private String concepto;
    @Column(name = "Montos")
    private Float monto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empleado_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Empleado empleado;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empresa_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Empresa empresa;

    @Column (name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;


    // Constructor
    public MovimientoDinero() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    // Getters and Setters
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

