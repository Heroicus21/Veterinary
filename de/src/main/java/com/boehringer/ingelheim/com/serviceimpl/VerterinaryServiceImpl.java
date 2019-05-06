/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.serviceimpl;

import com.boehringer.ingelheim.com.mapper.VeterinariaMapper;
import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelheim.com.repository.VeterinaryRepository;
import com.boehringer.ingelheim.com.service.VeterinaryService;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LucasRoman
 */
@Service
public class VerterinaryServiceImpl implements VeterinaryService{

    @Autowired
    private VeterinariaMapper mapper;
    
    @Autowired
    private VeterinaryRepository repository;
    
    
    @Override
    public VeterinaryDTO add(VeterinaryDTO source) throws Exception {
        
                try{
                    Veterinary veterinaryAdd= mapper.toEntity(source);            
                    Veterinary result=repository.save(veterinaryAdd);
            return mapper.toDTO(result);
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        throw new Exception("No se realizo la accion");

    }

    @Override
    public VeterinaryDTO edit(VeterinaryDTO source) throws Exception {
        
        try{
            Veterinary main=repository.findOne(source.getIdVeterinaria());                    
            Veterinary edited = mapper.toEntity(source);
            main=edited;            
            Veterinary result=repository.save(edited);
            return mapper.toDTO(result);
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        throw new Exception("No se realizo la accion");

    }

    @Override
    public Collection<VeterinaryDTO> list() throws Exception {
        try {
            Collection<Veterinary> collection=repository.findAll();    
            return mapper.toDTOS(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }                         
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VeterinaryDTO source) throws Exception {
        
        try {
            Veterinary toDelete=repository.getOne(source.getIdVeterinaria());            
            repository.delete(toDelete);
            
        } catch (Exception e) {
            throw new UnsupportedOperationException("No se pudo realizar la tarea."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
