/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controllerimpl;

import com.boehringer.ingelheim.com.service.VeterinaryService;
import com.boehringer.ingelhein.com.controller.VeterinariaController;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LucasRoman
 */
@RestController
@RequestMapping("/clinic/veterinary")
public class VeterinariaControllerImpl implements VeterinariaController{
    @Autowired
    private VeterinaryService service;
    
    
    @Override
    @PostMapping(value="/edit")
    public VeterinaryDTO edit(@RequestBody(required = true) VeterinaryDTO source) throws Exception{    
        return service.edit(source);
    }

    @Override
    @PutMapping(value="/add")
    public VeterinaryDTO add(VeterinaryDTO source) throws Exception {
        return service.add(source);                
    }

    @Override
    @GetMapping(value = "/all")
    public Collection<VeterinaryDTO> list() throws Exception {
        return service.list();
    }

    @Override
    @DeleteMapping(value="/delete")
    public void delete(VeterinaryDTO source) throws Exception {
        service.delete(source);        
    }

    @Override
    @GetMapping("/{name}/{pageable}")
    public Collection<VeterinaryDTO> findByName(@PathVariable(required =true)String name, @PathVariable(required =true)PageRequest pageable) throws Exception {
        try {
           return service.findByName(name, pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
