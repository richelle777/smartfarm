package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandearticleId implements Serializable {
    private static final long serialVersionUID = 5491876019970880265L;
    @Column(name = "idArticle", nullable = false)
    private String idArticle;
    @Column(name = "idCommande", nullable = false)
    private String idCommande;

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, idCommande);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommandearticleId entity = (CommandearticleId) o;
        return Objects.equals(this.idArticle, entity.idArticle) &&
                Objects.equals(this.idCommande, entity.idCommande);
    }
}