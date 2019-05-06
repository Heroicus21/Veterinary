/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controllerimpl;

import com.boehringer.ingelheim.com.service.ClientService;
import com.boehringer.ingelheim.com.service.VeterinaryService;
import com.boehringer.ingelhein.com.controller.ClientController;
import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/clinic/client")
public class ClientControllerImpl implements ClientController{

    @Autowired
    private ClientService service;
    
    @Autowired
    private VeterinaryService veterinaryService;
            
    
    @PutMapping(value="/add")
    public ClientDTO add(ClientDTO source) throws Exception {        
        return service.add(source);        
    }

    
    @PostMapping(value="/edit")
    public ClientDTO edit(ClientDTO source) throws Exception {        
        return service.edit(source);       
    }

    
    @GetMapping(value="/all")
    public Collection<ClientDTO> list() throws Exception {        
        return service.list();        
    }

    
    @DeleteMapping(value="/delete")
    public void delete(ClientDTO source) throws Exception {
        service.delete(source);
    }

    /**
     *
     * @param VeterinaryDTO source
     * @return Collection<ClientDTO>
     *  Metodo que hace una busqueda por veterinaria y retorna una lisat de clientes.
     * @throws Exception
     */
    @GetMapping(value="/{veterinary}")
    public Collection<ClientDTO> findByVeterinary(@PathVariable(required = true)VeterinaryDTO veterinary ) throws Exception {
        return service.findByVeterinary(veterinary);        
    }
    
}
