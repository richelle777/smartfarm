package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.entities.Article;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {CategorieMapper.class, ImageMapper.class, FermierMapper.class}
)
public interface ArticleMapper {
    @Mapping(target = "categorie", source = "articleDto.categorieDto")
    @Mapping(target = "fermier", source = "articleDto.fermierDto")
    @Mapping(target = "image", source = "articleDto.imageDto")
    Article toEntity(ArticleDto articleDto);

    @Mapping(target = "categorieDto", source = "article.categorie")
    @Mapping(target = "fermierDto", source = "article.fermier")
    @Mapping(target = "imageDto", source = "article.image")
    ArticleDto toDto(Article article);

    @Mapping(target = "categorie", source = "articleDto.categorieDto")
    @Mapping(target = "fermier", source = "articleDto.fermierDto")
    @Mapping(target = "image", source = "articleDto.imageDto")
    void copy(ArticleDto articleDto, @MappingTarget Article article);
}
