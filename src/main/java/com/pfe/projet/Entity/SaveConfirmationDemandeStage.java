package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveConfirmationDemandeStage {
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String confirmationStage;

    public static ConfirmationDemandeStage toEntity(SaveConfirmationDemandeStage model) {
        if (model == null) {
            return null;
        }
        ConfirmationDemandeStage confirmationStage = new ConfirmationDemandeStage();
        confirmationStage.setId(model.getId());
        confirmationStage.setConfirmationStage(model.getConfirmationStage());
        return confirmationStage;
    }
}

