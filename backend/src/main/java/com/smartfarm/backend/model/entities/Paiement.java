package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "paiement", indexes = {
        @Index(name = "idCommande", columnList = "idCommande")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paiement {
    @Id
    @Column(name = "idPaiement", nullable = false)
    private String id;

    @Column(name = "montant", nullable = false)
    private Long montant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCommande", nullable = false)
    private Commande commande;
}