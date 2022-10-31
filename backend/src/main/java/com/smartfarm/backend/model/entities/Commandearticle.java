package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "commandearticle", indexes = {
        @Index(name = "id_commande", columnList = "id_commande")
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