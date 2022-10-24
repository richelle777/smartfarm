package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.ImageDto;
import com.smartfarm.backend.model.entities.Image;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ImageMapper {
    Image toEntity(ImageDto imageDto);

    ImageDto toDto(Image image);

    void copy(ImageDto imageDto, @MappingTarget Image image);
}
