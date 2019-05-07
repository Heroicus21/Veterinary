/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.serviceimpl;

import com.boehringer.ingelheim.com.mapper.ClientMapper;
import com.boehringer.ingelheim.com.mapper.PetMapper;
import com.boehringer.ingelheim.com.model.Client;
import com.boehringer.ingelheim.com.model.Pet;
import com.boehringer.ingelheim.com.repository.ClientRepository;
import com.boehringer.ingelheim.com.repository.PetRepository;
import com.boehringer.ingelheim.com.service.PetService;
import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.PetDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author LucasRoman
 */
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository repository;
       
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ClientMapper clientMapper;
    
    @Autowired
    private PetMapper mapper;
    
    @Override
    public PetDTO add(PetDTO source) throws Exception {
        try {
            Client clientResult=clientRepository.getOne(source.getClient().getIdClient());
            if (clientResult!=null) {
                Pet pet=mapper.toEntity(source);
                pet.setClient(clientResult);                
                Pet result=repository.save(pet);                                
                return mapper.toDTO(result);
            }else{
                throw new UnsupportedOperationException("No se pudo realizar la operacion."); //To change body of generated methods, choose Tools | Templates.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PetDTO edit(PetDTO source) throws Exception {        
        try {
            Client clientResult=clientRepository.getOne(source.getClient().getIdClient());
            if (clientResult!=null) {
                Pet pet=mapper.toEntity(source);
                pet.setClient(clientResult);                
                Pet result=repository.save(pet);                                
                return mapper.toDTO(result);
            }else{
                throw new UnsupportedOperationException("No se pudo realizar la operacion."); //To change body of generated methods, choose Tools | Templates.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<PetDTO> list() throws Exception {        
        try {
            Collection<Pet> list=repository.findAll();
            
            return mapper.toDTOS(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PetDTO source) throws Exception {        
        try {
            repository.delete(source.getIdPet());                        
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public Collection<PetDTO> findByClient(ClientDTO source) throws Exception {
        
        try {
            Client client=clientRepository.getOne(source.getIdClient());            
            Collection<Pet> result= repository.findByClient(client);
            
            return mapper.toDTOS(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<PetDTO> findByClientName(String source, PageRequest pageRequest) throws Exception {
        
        try {
            Collection<Pet> result=repository.findByClientName(source, pageRequest);
//            Collection<Pet> result= new ArrayList<Pet>();
            return mapper.toDTOS(result);
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
