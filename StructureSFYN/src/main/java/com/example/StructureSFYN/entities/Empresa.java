package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // Atributos

    @Column(name = "Nit")
    private Long nitEmpresa;
    @Column(name = "Nombre")
    private String nombreEmpresa;
    @Column(name = "Tipo")
    private String tipoEmpresa;
    @Column(name = "Ciudad")
    private String ciudadEmpresa;
    @Column(name = "Direccion")
    private String direccionEmpresa;
    @Column(name = "Telefono")
    private String telefonoEmpresa;
    @Column(name = "Correo")
    private String correoEmpresa;

    @OneToMany
    private List<Empleado> empleadoList;

    @OneToMany
    @JoinColumn(name = "movimientos")
    private List<MovimientoDinero> transacciones;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updateAt")
    private Date updatedAt;


    //Método Constructor


    public Empresa() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Empresa(Long nitEmpresa, String nombreEmpresa, String tipoEmpresa, String ciudadEmpresa, String direccionEmpresa, String telefonoEmpresa, String correoEmpresa, List<Empleado> empleadoList, List<MovimientoDinero> transacciones) {
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.correoEmpresa = correoEmpresa;
        this.empleadoList = empleadoList;
        this.transacciones = transacciones;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    //get set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(Long nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<MovimientoDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<MovimientoDinero> transaciones) {
        this.transacciones = transaciones;
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

