package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Movimiento Dinero")
public class MovimientoDinero implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    // Atributos
    @Column (name = "Monto Movimiento")
    private Float montoMovimiento;
    @Column(name = "Montos Positivos")
    private Float montosPositivos;
    @Column(name = "Montos Negativos")
    private Float montosNegativos;
    @Column (name = "Concepto Movimiento")
    private String conceptoMovimiento;
    @Column (name = "Usuario Contabilidad")
    private String usuarioContabilidad;

    // Método constructor
    public MovimientoDinero (){};

    public MovimientoDinero (Float montoMovimiento, Float montosPositivos, Float montosNegativos, String conceptoMovimiento, String usuarioContabilidad) {
        this.montoMovimiento = montoMovimiento;
        this.montosPositivos = montosPositivos;
        this.montosNegativos = montosNegativos;
        this.conceptoMovimiento = conceptoMovimiento;
        this.usuarioContabilidad = usuarioContabilidad;
    }
    // Métodos getter and setter
    public Float getMontoMovimiento() {

        return montoMovimiento;
    }

    public void setMontoMovimiento(Float montoMovimiento) {

        this.montoMovimiento = montoMovimiento;
    }

    public Float getMontosPositivos() {

        return montosPositivos;
    }

    public void setMontosPositivos(Float montosPositivos) {

        this.montosPositivos = montosPositivos;
    }

    public Float getMontosNegativos() {

        return montosNegativos;
    }

    public void setMontosNegativos(Float montosNegativos) {

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

