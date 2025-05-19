package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveDemandeStage {
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String demandeStage;

    public static DemandeStage toEntity(SaveDemandeStage model) {
        if (model == null) {
            return null;
        }
        DemandeStage demande = new DemandeStage();
        demande.setId(model.getId());
        demande.setDemandeStage(model.getDemandeStage());
        return demande;
    }
}
