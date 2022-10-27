package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandearticleIdDto implements Serializable {
    private static final long serialVersionUID = 5491876019970880265L;
    private String idArticle;
    private String idCommande;
}
