/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author LucasRoman
 */
@Entity
@Table(name = "veterinary")
public class Veterinary {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idVeterinaria;    
    private String name;
    private String code;
    private String adress;
    private String locality;
    private String zipCode;

    public Veterinary() {
    }

    public Veterinary(String name, String code, String adress, String locality, String zipCode) {
        this.name = name;
        this.code = code;
        this.adress = adress;
        this.locality = locality;
        this.zipCode = zipCode;
    }
    
    public Long getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(Long idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
    
}
