package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "article", indexes = {
        @Index(name = "idCategorie", columnList = "idCategorie"),
        @Index(name = "idImage", columnList = "idImage"),
        @Index(name = "idFermier", columnList = "idFermier")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    @Id
    @Column(name = "idArticle", nullable = false)
    private String id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "descript")
    private String description;

    @Column(name = "prixU", nullable = false)
    private Integer prixU;

    @Column(name = "qte")
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idImage")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "idFermier")
    private Fermier fermier;
}