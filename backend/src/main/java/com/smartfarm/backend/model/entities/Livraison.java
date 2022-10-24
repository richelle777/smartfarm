package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "livraison", indexes = {
        @Index(name = "idLocalisation", columnList = "idLocalisation"),
        @Index(name = "idCommande", columnList = "idCommande")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Livraison {
    @Id
    @Column(name = "idLivraison", nullable = false)
    private String id;

    @Column(name = "dateLiv")
    private LocalDate date;

    @Lob
    @Column(name = "statutLivraison")
    private String statutLivraison;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idLocalisation", nullable = false)
    private Localisation localisation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCommande", nullable = false)
    private Commande commande;
}