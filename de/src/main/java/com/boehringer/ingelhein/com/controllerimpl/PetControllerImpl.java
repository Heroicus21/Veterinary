/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controllerimpl;

import com.boehringer.ingelheim.com.service.ClientService;
import com.boehringer.ingelheim.com.service.PetService;
import com.boehringer.ingelhein.com.controller.PetController;
import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.PetDTO;
import java.util.Collection;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LucasRoman
 */
@RestController
@RequestMapping(value=("/clinic/pet"))
public class PetControllerImpl implements PetController{

    @Autowired
    private PetService service;
    
    @Autowired
    private ClientService clientService;
    
    @Override
    @PutMapping(value="/add")
    public PetDTO add(PetDTO source) throws Exception {        
       return service.add(source);     
    }

    @Override
    @PostMapping(value="/edit")
    public PetDTO edit(PetDTO source) throws Exception {        
        return service.edit(source);        
    }

    @Override
    @GetMapping(value="/all")
    public Collection<PetDTO> list() throws Exception {        
        return service.list();        
    }

    @Override
    @DeleteMapping(value="/delete")
    public void delete(PetDTO source) throws Exception {
        service.delete(source);        
    }

    /**
     *
     * @param ClientDTO source
     * @return Collection<PetDTO> 
     *      Metodo de busqueda el cual busca a partir de un cliente las mascotas relacionadas con el mismo.
     * @throws Exception
     */
    @Override
    @GetMapping(value="/{source}")
    public Collection<PetDTO> findByClient(@PathVariable(required =true)ClientDTO source) throws Exception {
        return service.findByClient(source);
        
    }
    
}
