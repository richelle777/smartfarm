package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "commande", indexes = {
        @Index(name = "id_client", columnList = "id_client"),
        @Index(name = "id_livraison", columnList = "id_livraison")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commande {
    @Id
    @Column(name = "id_commande", nullable = false)
    private String id;

    @Column(name = "date_com", nullable = false)
    private LocalDate date;

    @Column(name = "livre", nullable = false)
    private Boolean livre = false;

    @Lob
    @Column(name = "statut_commande", nullable = false)
    private String statutCommande;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Customer client;

    @ManyToOne
    @JoinColumn(name = "id_livraison")
    private Livraison livraison;

}