package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveRapportEncadrant {
    private Long id ;
    @Lob
    @Column(columnDefinition = "LongText")
    private String rapportEncadrant ;
    private String description ;
    private Long idEtudiant;
    private Long idEncadrant;

    public static RapportEncadrant toEntity(SaveRapportEncadrant model) {
        if (model == null) {
            return null;
        }

        RapportEncadrant rapportEncadrant = new RapportEncadrant();
        rapportEncadrant.setId(model.getId());
        rapportEncadrant.setRapportEncadrant(model.getRapportEncadrant());
        rapportEncadrant.setDescription(model.getDescription());

        if (model.getIdEtudiant() != null) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(model.getIdEtudiant());
            rapportEncadrant.setEtudiant(etudiant);
        }

        if (model.getIdEncadrant() != null) {
            Encadrant encadrant = new Encadrant();
            encadrant.setId(model.getIdEncadrant());
            rapportEncadrant.setEncadrant(encadrant);
        }
        return rapportEncadrant;
    }
}
