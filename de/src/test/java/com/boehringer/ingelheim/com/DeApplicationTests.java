package com.boehringer.ingelheim.com;

import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelheim.com.repository.ClientRepository;
import com.boehringer.ingelheim.com.repository.PetRepository;
import com.boehringer.ingelheim.com.repository.VeterinaryRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class DeApplicationTests {
        
        @MockBean
        private VeterinaryRepository veterinaryRepo;
    
        @MockBean
        private ClientRepository clientRepo;
        
        @MockBean
        private PetRepository petRepo;
        @Autowired
        MockMvc mockMvc;
        
        @Test
	public void contextLoads() {
            Mockito.when(veterinaryRepo.findAll()).thenReturn(Collections.EMPTY_LIST);
            Mockito.when(clientRepo.findAll()).thenReturn(Collections.EMPTY_LIST);
            Mockito.when(petRepo.findAll()).thenReturn(Collections.EMPTY_LIST);
            try {
                MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders
                        .get("/all/")
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn();
            } catch (Exception ex) {
                Logger.getLogger(DeApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            Mockito.verify(veterinaryRepo.findAll());
            Mockito.verify(clientRepo.findAll());
            Mockito.verify(petRepo.findAll());
	}
        
        @Test                
	public void addVeterinary() {
            Veterinary add=new Veterinary("PET SHOP", "E2F3", "Corrientes 2105", "Martinez", "1646");            
            Veterinary result=veterinaryRepo.save(add);
            Assert.assertNotNull(result);            
	}

}
