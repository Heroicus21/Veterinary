package com.boehringer.ingelheim.com;

import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelheim.com.repository.VeterinaryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeApplicationTests {
        
        @Autowired
        private VeterinaryRepository repository;
    
        @Test                
	public void addVeterinary() {
            Veterinary add=new Veterinary("PET SHOP", "E2F3", "Corrientes 2105", "Martinez", "1646");            
            Veterinary result=repository.save(add);
            Assert.assertNotNull(result);            
	}

}
