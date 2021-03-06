/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controller;

import com.boehringer.ingelhein.com.dto.ClientDTO;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author LucasRoman
 */
public interface ClientController {
    public ClientDTO add(ClientDTO source) throws Exception;    
    public ClientDTO edit(ClientDTO source) throws Exception;    
    public Collection<ClientDTO> list() throws Exception;    
    public void delete(ClientDTO source) throws Exception;
    public Collection<ClientDTO> findByVeterinary(VeterinaryDTO source) throws Exception;
    public Collection<ClientDTO> findByVeterinaryName(String source,PageRequest pageable) throws Exception;
}
