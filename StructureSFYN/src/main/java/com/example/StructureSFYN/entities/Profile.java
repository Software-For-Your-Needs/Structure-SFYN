package com.example.StructureSFYN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    //Se agrega el @id
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Atributos
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updateAt")
    private Date updatedAt;

    // Método constructor
    public Profile() {
    }

    public Profile(Integer id, String image, String phone, String nombre, Date createdAt, Date updatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.nombre = nombre;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
