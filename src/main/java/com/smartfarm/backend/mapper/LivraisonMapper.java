package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {LocalisationMapper.class}
)
public interface LivraisonMapper {
    @Mapping(target = "localisation", source = "livraisonDto.localisationDto")
    Livraison toEntity(LivraisonDto livraisonDto);

    @Mapping(target = "localisationDto", source = "livraison.localisation")
    LivraisonDto toDto(Livraison livraison);

    @Mapping(target = "localisation", source = "livraisonDto.localisationDto")
    void copy(LivraisonDto livraisonDto, @MappingTarget Livraison livraison);
}
