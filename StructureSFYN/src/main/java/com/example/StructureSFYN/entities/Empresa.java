package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
public class Empresa implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    // Atributos
    private int nitEmpresa;
    private String nombreEmpresa;
    private String tipoEmpresa;
    private String ciudadEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
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

