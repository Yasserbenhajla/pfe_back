package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveRapportFinal {

        private Long id;
        @Lob
        @Column(columnDefinition = "LongText")
        private String rapportFinal;
        @Lob
        @Column(columnDefinition = "LongText")
        private String autorisation;
        private Long idEtudiant;


        public static RapportFinal toEntity(SaveRapportFinal model) {
            if (model == null) {
                return null;
            }
            RapportFinal rapportFinal = new RapportFinal();
            rapportFinal.setId(model.getId());
            rapportFinal.setRapportFinal(model.getRapportFinal());
            rapportFinal.setAutorisation(model.getAutorisation());

            return rapportFinal;
        }
    }

