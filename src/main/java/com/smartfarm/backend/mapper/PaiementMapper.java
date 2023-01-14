package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.PaiementDto;
import com.smartfarm.backend.model.entities.Paiement;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {CommandeMapper.class}
)
public interface PaiementMapper {
    @Mapping(target = "commande", source = "paiementDto.commandeDto")
    Paiement toEntity(PaiementDto paiementDto);

    @Mapping(target = "commandeDto", source = "paiement.commande")
    PaiementDto toDto(Paiement paiement);

    @Mapping(target = "commande", source = "paiementDto.commandeDto")
    void copy(PaiementDto paiementDto, @MappingTarget Paiement paiement);
}
