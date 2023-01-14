package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.entities.Commande;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {LivraisonMapper.class, CustomerMapper.class}
)
public interface CommandeMapper {
    @Mapping(target = "client", source = "commandeDto.clientDto")
    @Mapping(target = "livraison", source = "commandeDto.livraisonDto")
    Commande toEntity(CommandeDto commandeDto);

    @Mapping(target = "clientDto", source = "commande.client")
    @Mapping(target = "livraisonDto", source = "commande.livraison")
    CommandeDto toDto(Commande commande);

    @Mapping(target = "client", source = "commandeDto.clientDto")
    @Mapping(target = "livraison", source = "commandeDto.livraisonDto")
    void copy(CommandeDto commandeDto, @MappingTarget Commande commande);
}
