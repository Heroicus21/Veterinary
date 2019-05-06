/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author LucasRoman
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idClient;
    
    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinary", insertable = true, updatable = true)
    private Veterinary veterinaria;
    private String name;
    private String lastName;
    private String dni;
    private String CelNumber;
    private String phoneNumber;

    public Client() {
    }

    public Client(Veterinary veterinaria, String name, String lastName, String dni, String CelNumber, String phoneNumber) {
        this.veterinaria = veterinaria;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.CelNumber = CelNumber;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Veterinary getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinary veterinaria) {
        this.veterinaria = veterinaria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelNumber() {
        return CelNumber;
    }

    public void setCelNumber(String CelNumber) {
        this.CelNumber = CelNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
}
