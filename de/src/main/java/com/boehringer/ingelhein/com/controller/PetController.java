/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controller;

import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.PetDTO;
import java.util.Collection;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author LucasRoman
 */
public interface PetController {
    public PetDTO add(PetDTO source) throws Exception;    
    public PetDTO edit(PetDTO source) throws Exception;    
    public Collection<PetDTO> list() throws Exception;    
    public void delete(PetDTO source) throws Exception;
    public Collection<PetDTO> findByClient(ClientDTO source) throws Exception;
    public Collection<PetDTO> findByClientName(String source,Pageable pageable) throws Exception;
}
