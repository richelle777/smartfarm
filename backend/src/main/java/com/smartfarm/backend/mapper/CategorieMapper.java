package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.model.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CategorieMapper {
    Categorie toEntity(CategorieDto categorieDto);

    CategorieDto toDto(Categorie categorie);

    void copy(CategorieDto categorieDto, @MappingTarget Categorie categorie);
}
