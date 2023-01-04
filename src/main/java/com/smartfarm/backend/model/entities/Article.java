package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "article", indexes = {
        @Index(name = "id_categorie", columnList = "id_categorie"),
        @Index(name = "id_image", columnList = "id_image"),
        @Index(name = "id_fermier", columnList = "id_fermier")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    @Id
    @Column(name = "id_article", nullable = false)
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
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_image")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "id_fermier")
    private Fermier fermier;
}