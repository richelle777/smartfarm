package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ArticleMapper {
    Article toEntity(ArticleDto articleDto);

    ArticleDto toDto(Article article);

    void copy(ArticleDto articleDto, @MappingTarget Article article);
}
