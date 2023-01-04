package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ArticleForListMapper {
    Article toEntity(ArticleDtoForList articleDtoForList);

    ArticleDtoForList toDto(Article article);

    void copy(ArticleDtoForList articleDto, @MappingTarget Article article);
}
