/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.repository;

import com.boehringer.ingelheim.com.model.Client;
import com.boehringer.ingelheim.com.model.Veterinary;

import java.util.Collection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author LucasRoman
 */
@Component
public interface ClientRepository extends JpaRepository<Client, Long>{
    Collection<Client> findByVeterinaria(Veterinary veterinary);
    Collection<Client> findByVeterinariaName(String name,Pageable pageable);
}