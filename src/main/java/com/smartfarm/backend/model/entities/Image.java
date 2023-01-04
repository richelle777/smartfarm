package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "image")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image {
    @Id
    @Column(name = "id_image", nullable = false)
    private String id;

    @Column(name = "url")
    private String url;

    @Column(name = "url_thumbnail")
    private String urlThumbnail;
}