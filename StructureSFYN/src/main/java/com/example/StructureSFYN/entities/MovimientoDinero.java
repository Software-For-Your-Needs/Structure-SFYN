package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "movimientoDinero")
public class MovimientoDinero implements Serializable{

    //Se agrega el @id
    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    // Atributos

    @Column(name= "montoMovimiento")
    private float montoMovimiento;

    @Column(name= "montosPositivos")
    private float montosPositivos;

    @Column(name= "montosNegativos")
    private float montosNegativos;

    @Column(name= "conceptoMovimiento")
    private String conceptoMovimiento;

    @Column(name= "usuarioContabilidad")
    private String usuarioContabilidad;

    // Método constructor
    public MovimientoDinero (){};

    public MovimientoDinero (float montoMovimiento, float montosPositivos, float montosNegativos, String conceptoMovimiento, String usuarioContabilidad) {
        this.montoMovimiento = montoMovimiento;
        this.montosPositivos = montosPositivos;
        this.montosNegativos = montosNegativos;
        this.conceptoMovimiento = conceptoMovimiento;
        this.usuarioContabilidad = usuarioContabilidad;
    }
    // Métodos getter and setter
    public float getMontoMovimiento() {

        return montoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {

        this.montoMovimiento = montoMovimiento;
    }

    public float getMontosPositivos() {

        return montosPositivos;
    }

    public void setMontosPositivos(float montosPositivos) {

        this.montosPositivos = montosPositivos;
    }

    public float getMontosNegativos() {

        return montosNegativos;
    }

    public void setMontosNegativos(float montosNegativos) {

        this.montosNegativos = montosNegativos;
    }

    public String getConceptoMovimiento() {

        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {

        this.conceptoMovimiento = conceptoMovimiento;
    }

    public String getUsuarioContabilidad() {

        return usuarioContabilidad;
    }

    public void setUsuarioContabilidad(String usuarioContabilidad) {

        this.usuarioContabilidad = usuarioContabilidad;
    }

    public float calcularGanancia(){

        return  this.montosPositivos - this.montosNegativos;

    }

    public String consultarEstadoCuenta(){

        if(calcularGanancia() < 0){
            return "Es deudor";
        }else{
            return "paz y salvo";
        }

    }

}

