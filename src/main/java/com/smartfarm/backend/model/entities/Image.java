package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "image")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image {
    @Id
    @Column(name = "id_image", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "data", nullable = false)
    @Lob
    private byte[] data;

    public Image(String name, byte[]data){
        this.name = name;
        this.data = data;
    }
}