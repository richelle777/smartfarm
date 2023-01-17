package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "paiement", indexes = {
        @Index(name = "id_commande", columnList = "id_commande")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paiement {

    @Id
    @Column(name = "id_paiement", nullable = false)
    private String id;

    @Column(name = "montant", nullable = false)
    private Long montant;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;
}