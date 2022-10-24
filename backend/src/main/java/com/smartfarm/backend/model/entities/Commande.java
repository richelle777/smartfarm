package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "commande", indexes = {
        @Index(name = "idClient", columnList = "idClient")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commande {
    @Id
    @Column(name = "idCommande", nullable = false)
    private String id;

    @Column(name = "dateCom", nullable = false)
    private LocalDate date;

    @Column(name = "livre", nullable = false)
    private Boolean livre = false;

    @Lob
    @Column(name = "statutCommande", nullable = false)
    private String statutCommande;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Customer client;
}