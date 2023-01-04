package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface LivraisonMapper {
    Livraison toEntity(LivraisonDto livraisonDto);

    LivraisonDto toDto(Livraison livraison);

    void copy(LivraisonDto livraisonDto, @MappingTarget Livraison livraison);
}
