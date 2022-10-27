package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "commandearticle", indexes = {
        @Index(name = "idCommande", columnList = "idCommande")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commandearticle {
    @EmbeddedId
    private CommandearticleId id;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;
}