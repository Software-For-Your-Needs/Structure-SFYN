package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "empresa")
public class Empresa {

    //Se agrega el @id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Atributos
    @Column(name = "nit")
    private Long nitEmpresa;
    @Column(name = "nombre")
    private String nombreEmpresa;
    @Column(name = "tipo")
    private String tipoEmpresa;
    @Column(name = "ciudad")
    private String ciudadEmpresa;
    @Column(name = "direccion")
    private String direccionEmpresa;
    @Column(name = "telefono")
    private String telefonoEmpresa;
    @Column(name = "correo")
    private String correoEmpresa;

    //Método Constructor

    public Empresa() {
    }

    public Empresa(Long nitEmpresa, String nombreEmpresa, String tipoEmpresa, String ciudadEmpresa, String direccionEmpresa, String telefonoEmpresa, String correoEmpresa) {
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.correoEmpresa = correoEmpresa;
    }

    // Métodos getter and setter
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
}

