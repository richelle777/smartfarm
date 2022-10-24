package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.entities.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CommandeMapper {
    Commande toEntity(CommandeDto commandeDto);

    CommandeDto toDto(Commande commande);

    void copy(CommandeDto commandeDto, @MappingTarget Commande commande);
}
