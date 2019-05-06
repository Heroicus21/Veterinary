/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com;

import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelheim.com.repository.VeterinaryRepository;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author LucasRoman
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VeterinaryTest {
        
        @Autowired
        private VeterinaryRepository repository;
    
        @Test                
	public void addVeterinary() {
            Veterinary add=new Veterinary("PET SHOP", "E2F3", "Corrientes 2105", "Martinez", "1646");            
            Veterinary result=repository.save(add);
            Assert.assertNotNull(result);            
	}
        
        @Test                
	public void listVeterinaries() {
            
            Collection<Veterinary> result=repository.findAll();
            Assert.assertNotNull(result);            
	}
    
}
