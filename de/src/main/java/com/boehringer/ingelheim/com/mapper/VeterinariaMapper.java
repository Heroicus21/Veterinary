/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.mapper;

import com.boehringer.ingelheim.com.model.Veterinary;
import com.boehringer.ingelhein.com.dto.VeterinaryDTO;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author LucasRoman
 */
@Mapper
public interface VeterinariaMapper {
        VeterinariaMapper INSTANCE = Mappers.getMapper( VeterinariaMapper.class );
    
    Veterinary toEntity(VeterinaryDTO source);    
    Collection<Veterinary> toEntityes(Collection<VeterinaryDTO> source);    
    VeterinaryDTO toDTO(Veterinary source);    
    Collection<VeterinaryDTO> toDTOS(Collection<Veterinary> source);
}
