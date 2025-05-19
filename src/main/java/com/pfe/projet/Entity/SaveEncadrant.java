package com.pfe.projet.Entity;

import lombok.Data;

@Data
public class SaveEncadrant {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String tel;
    private Long idQualite;
    private Long idSpecialite;

    public static Encadrant toEntity(SaveEncadrant model) {
        if (model == null) {
            return null;
        }
        Encadrant encadrant = new Encadrant();
        encadrant.setId(model.getId());
        encadrant.setNom(model.getNom());
        encadrant.setPrenom(model.getPrenom());
        encadrant.setEmail(model.getEmail());
        encadrant.setPassword(model.getPassword());
        encadrant.setTel(model.getTel());


        return encadrant;
    }
}
