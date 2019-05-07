/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.service;

import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.PetDTO;
import java.util.Collection;
import org.springframework.data.domain.PageRequest;


/**
 *
 * @author LucasRoman
 */
public interface PetService {
    public PetDTO add(PetDTO source) throws Exception;    
    public PetDTO edit(PetDTO source) throws Exception;    
    public Collection<PetDTO> list() throws Exception;    
    public void delete(PetDTO source) throws Exception;
    public Collection<PetDTO> findByClient(ClientDTO source) throws Exception;    
    public Collection<PetDTO> findByClientName(String source,PageRequest pageRequest) throws Exception; 
}
