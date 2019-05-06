/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelhein.com.controller;

import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;

/**
 *
 * @author LucasRoman
 */
public interface VeterinariaController {
    public VeterinaryDTO add(VeterinaryDTO source) throws Exception;    
    public VeterinaryDTO edit(VeterinaryDTO source) throws Exception;    
    public Collection<VeterinaryDTO> list() throws Exception;    
    public void delete(VeterinaryDTO source) throws Exception;
}
