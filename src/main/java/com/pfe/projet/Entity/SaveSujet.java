package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveSujet {
    private Long id;
    @Lob
    @Column(columnDefinition = "LongText")
    private String description;
    private boolean status;
    private Long idEtudiant;


    public static Sujet toEntity(SaveSujet model, Etudiant etudiant) {
        if (model == null) {
            return null;
        }

        Sujet sujet = new Sujet();
        sujet.setId(model.getId());
        sujet.setDescription(model.getDescription());
        sujet.setStatus(model.isStatus());
        sujet.setEtudiant(etudiant);


        return sujet;
    }
}
