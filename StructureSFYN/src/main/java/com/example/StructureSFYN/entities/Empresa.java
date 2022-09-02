package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "empresa")
public class Empresa implements Serializable{

    //Se agrega el @id
    private static final int serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    // Atributos

    @Column(name= "nitEmpresa")
    private int nitEmpresa;

    @Column(name= "nombreEmpresa")
    private String nombreEmpresa;

    @Column(name= "tipoEmpresa")
    private String tipoEmpresa;

    @Column(name= "ciudadEmpresa")
    private String ciudadEmpresa;

    @Column(name= "direccionEmpresa")
    private String direccionEmpresa;

    @Column(name= "telefonoEmpresa")
    private String telefonoEmpresa;

    @Column(name= "correoEmpresa")
    private String correoEmpresa;

    //Método Constructor

    public Empresa() {
    }

    public Empresa(int nitEmpresa, String nombreEmpresa, String tipoEmpresa, String ciudadEmpresa, String direccionEmpresa, String telefonoEmpresa, String correoEmpresa) {
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.correoEmpresa = correoEmpresa;
    }

    // Métodos getter and setter
    public int getNitEmpresa() {

        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {

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

