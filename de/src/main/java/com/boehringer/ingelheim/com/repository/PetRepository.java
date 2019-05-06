/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.repository;

import com.boehringer.ingelheim.com.model.Client;
import com.boehringer.ingelheim.com.model.Pet;

import java.util.Collection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author LucasRoman
 */
@Component
public interface PetRepository extends JpaRepository<Pet, Long>{
    Collection<Pet> findByClient(Client client);
    Collection<Pet> findByClientName(String name,Pageable pageable);
}