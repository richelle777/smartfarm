package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.ArticleMapper;
import com.smartfarm.backend.mapper.CommandearticleIdMapper;
import com.smartfarm.backend.mapper.CommandearticleMapper;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.dto.CommandearticleDto;
import com.smartfarm.backend.model.dto.Produit;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.repository.CommandearticleRepository;
import com.smartfarm.backend.service.IArticle;
import com.smartfarm.backend.service.ICommandearticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommandearticleServiceImpl implements ICommandearticle {

    @Autowired
    CommandearticleRepository commandearticleRepository;

    @Autowired
    CommandearticleMapper commandearticleMapper;

    @Autowired
    CommandearticleIdMapper commandearticleIdMapper;

    @Autowired
    IArticle iArticle;


    @Override
    public List<Produit> listArticleByCommande(String id){
        return commandearticleRepository.findByIdIdCommande(id).get().stream()
                .map(commandearticle -> {
                    Produit produit = new Produit();
                    produit.setArticleDto(iArticle.findById(commandearticle.getId().getIdArticle()));
                    produit.setQuantity(commandearticle.getQuantite());
                    return produit;
                })
                .collect(Collectors.toList());
    }


    @Override
    public String saveCommandeArticle(CommandearticleDto commandearticleDto) {
        if (commandearticleRepository.findById(commandearticleDto.getId()).isPresent()){
            return "0";
        }
        else {
            return commandearticleRepository.save(commandearticleMapper.toEntity(commandearticleDto)).getId().toString();
        }
    }


    @Override
    public int deleteCommandeArticleById(String id) {
        commandearticleRepository.deleteCommandeArticleById(id);
        return 1;
    }
    @Override
    public int UpdateCommandeArticle(Integer qte , String id) {
        commandearticleRepository.updateCommandeArticle(qte, id);
        return 1;
    }

    @Override
    public List<CommandearticleDto> listCommandeArticles() {
        List<CommandearticleDto> commandearticleDtos = commandearticleRepository.findAll().stream().map(commande ->{
            System.out.println(commande);
           CommandearticleDto commandearticleDto = commandearticleMapper.toDto(commande);
            System.out.println(commandearticleDto);
            commandearticleDto.setId(commande.getId());
            return commandearticleDto;
        }).collect(Collectors.toList());
        return commandearticleDtos;
    }

}
