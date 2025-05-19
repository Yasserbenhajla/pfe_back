package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveLettreAffectation {
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String lettreAffectation;

    public static LettreAffectation toEntity(SaveLettreAffectation model) {
        if (model == null) {
            return null;
        }
        LettreAffectation lettreAffectation = new LettreAffectation();
        lettreAffectation.setId(model.getId());
        lettreAffectation.setLettreAffectation(model.getLettreAffectation());
        return lettreAffectation;
    }
}

