/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.mapper;

import com.boehringer.ingelheim.com.model.Pet;
import com.boehringer.ingelhein.com.dto.PetDTO;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author LucasRoman
 */
@Mapper(uses = { ClientMapper.class } )
public interface PetMapper {
                PetMapper INSTANCE = Mappers.getMapper( PetMapper.class );
    
    Pet toEntity(PetDTO source);    
    Collection<Pet> toEntityes(Collection<PetDTO> source);    
    PetDTO toDTO(Pet source);    
    Collection<PetDTO> toDTOS(Collection<Pet> source);
}
