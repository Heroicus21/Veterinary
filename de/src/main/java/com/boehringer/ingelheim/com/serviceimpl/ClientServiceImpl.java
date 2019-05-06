/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.serviceimpl;

import com.boehringer.ingelheim.com.mapper.ClientMapper;
import com.boehringer.ingelheim.com.model.Client;
import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelheim.com.repository.ClientRepository;
import com.boehringer.ingelheim.com.repository.VeterinaryRepository;
import com.boehringer.ingelheim.com.service.ClientService;
import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



/**
 *
 * @author LucasRoman
 */

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repository;
    
    @Autowired
    private ClientMapper mapper;
        
    @Autowired
    private VeterinaryRepository veterinaryRepository;    

    @Override
    public ClientDTO add(ClientDTO source) throws Exception {
                try {
                    Long id= source.getVeterinaria().getIdVeterinaria();
                    Veterinary veterinaryResult=veterinaryRepository.findOne(id);
                    if (veterinaryResult!=null) {
                         Client client=mapper.toEntity(source);
                        client.setVeterinaria(veterinaryResult);                
                        Client result=repository.save(client);                                
                        return mapper.toDTO(result);
                    }else{
                        throw new UnsupportedOperationException("No se pudo realizar la operacion."); 
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Ocurrio un error.");
    }

    @Override
    public ClientDTO edit(ClientDTO source) throws Exception {
        try {
            Long id= source.getVeterinaria().getIdVeterinaria();
            Veterinary veterinaryResult=veterinaryRepository.findOne(id);
            if (veterinaryResult!=null) {
                Client main =repository.findOne(source.getIdClient());
                if(main!=null){
                    
                    Client client=mapper.toEntity(source);
                    client.setVeterinaria(veterinaryResult);                
                    Client result=repository.save(client);                                
                    return mapper.toDTO(result);
                }
                
            }else{
                throw new UnsupportedOperationException("No se pudo realizar la operacion.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Ocurrio un error.");
    }

    @Override
    public Collection<ClientDTO> list() throws Exception {
        try {
            Collection<Client>list =repository.findAll();        
            return mapper.toDTOS(list);
        } catch (Exception e) {
            e.printStackTrace();
        }                
        throw new UnsupportedOperationException("Ocurrio un error.");
    }

    @Override
    public void delete(ClientDTO source) throws Exception {
        try {
            Client client=repository.findOne(source.getIdClient());
            repository.delete(client);
        } catch (Exception e) {
            e.printStackTrace();
        }               
    }

    @Override
    public Collection<ClientDTO> findByVeterinary(VeterinaryDTO source) throws Exception {
        try {
            Veterinary finded=veterinaryRepository.findOne(source.getIdVeterinaria());
            Collection<Client> result=repository.findByVeterinaria(finded);            
            return mapper.toDTOS(result);
        } catch (Exception e) {
            e.printStackTrace();
        }                
        throw new UnsupportedOperationException("Ocurrio un error."); 
    }

    @Override
    public Collection<ClientDTO> findByName(String source, Pageable pageRequest) throws Exception {
        
        try {
            Collection<Client> result=repository.findByVeterinariaName(source, pageRequest);
            return mapper.toDTOS(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
