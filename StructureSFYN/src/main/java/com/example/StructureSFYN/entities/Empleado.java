package com.example.StructureSFYN.entities;

import com.example.StructureSFYN.enums.Enum_RoleName;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "empleado", uniqueConstraints = {@UniqueConstraint(columnNames = {"correoEmpleado"})})
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Se define la PK llave primaria
    private Integer id;

    @NotNull
    private String correoEmpleado;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "rolEmpleado")
    private Enum_RoleName rolEmpleado;

    @OneToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;


    @ManyToOne(optional = false)
    @JsonIgnoreProperties("empleado")
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<MovimientoDinero> movimientoDinero = new HashSet<>();


    @Column(name = "updatedAt")
    private Date upDatedAt;

    @Column(name = "createdAt")
    private Date createdAt;

    // Constructor
    public Empleado() {
        this.upDatedAt = new Date();
        this.createdAt = new Date();
    }
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<MovimientoDinero> getMovimientoDinero() {
        return movimientoDinero;
    }

    public void setMovimientoDinero(Set<MovimientoDinero> movimientoDinero) {
        this.movimientoDinero = movimientoDinero;
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