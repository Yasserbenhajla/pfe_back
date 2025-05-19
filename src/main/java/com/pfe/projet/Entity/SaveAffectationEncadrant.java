    package com.pfe.projet.Entity;
    import lombok.Data;

    @Data
    public class SaveAffectationEncadrant {
        private Long id ;
        private Long idSujet;
        private Long idEncadrant;

        public static AffectationEncadrant  toEntity(SaveAffectationEncadrant model, Sujet sujet, Encadrant encadrant)
        {
            AffectationEncadrant affectationEncadrant = new AffectationEncadrant();
            affectationEncadrant.setId(model.getId());
            affectationEncadrant.setSujet(sujet);
            affectationEncadrant.setEncadrant(encadrant);

            return affectationEncadrant;
        }

    }
