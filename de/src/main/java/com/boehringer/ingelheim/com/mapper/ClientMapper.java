/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boehringer.ingelheim.com.mapper;

import com.boehringer.ingelheim.com.model.Client;
import com.boehringer.ingelhein.com.dto.ClientDTO;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author LucasRoman
 */
@Mapper(uses = { VeterinariaMapper.class } )
public interface ClientMapper {
            ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );
    
    Client toEntity(ClientDTO source);    
    Collection<Client> toEntityes(Collection<ClientDTO> source);    
    ClientDTO toDTO(Client source);    
    Collection<ClientDTO> toDTOS(Collection<Client> source);
}
