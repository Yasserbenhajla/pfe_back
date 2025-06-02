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
    private int status=0;
    private Long idEtudiant;
    private Long idStage;


    public static Sujet toEntity(SaveSujet model, Etudiant etudiant, Stage stage) {
        if (model == null) {
            return null;
        }

        Sujet sujet = new Sujet();
        sujet.setId(model.getId());
        sujet.setDescription(model.getDescription());

        sujet.setEtudiant(etudiant);
        sujet.setStage(stage);


        return sujet;
    }
}
