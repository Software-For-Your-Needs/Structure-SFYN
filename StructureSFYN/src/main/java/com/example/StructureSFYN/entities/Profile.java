package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Profile implements Serializable{

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    //Atributos
    private String image;
    private String phone;
    private Empleado empleado;
    private Date createdAt;
    private Date updatedAt;

    // Método constructor
    public Profile() {
    }

    public Profile(String image, String phone, Empleado empleado, Date createdAt, Date updatedAt) {
        this.image = image;
        this.phone = phone;
        this.empleado = empleado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Métodos getter and setter


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Empleado getUser() {
        return empleado;
    }

    public void setUser(Empleado empleado) {
        this.empleado = empleado;
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
