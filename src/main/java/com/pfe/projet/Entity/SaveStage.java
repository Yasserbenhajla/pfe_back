package com.pfe.projet.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class SaveStage {
    private Long id;
    private String intitule;
    private String description;
    private String lieu;
    private String pays;
    private String technologieOutil;
    private String nomEntreprise;
    private Date dateDeb;
    private Date dateFin;
    private Long etudiantId;
    private Long typeDeStageId;


    public static Stage toEntity(SaveStage model) {


        Stage stage = new Stage();
        stage.setId(model.getId());
        stage.setIntitule(model.getIntitule());
        stage.setDescription(model.getDescription());
        stage.setLieu(model.getLieu());
        stage.setPays(model.getPays());
        stage.setTechnologieOutil(model.getTechnologieOutil());
        stage.setNomEntreprise(model.getNomEntreprise());
        stage.setDateDeb(model.getDateDeb());
        stage.setDateFin(model.getDateFin());
        return stage;
    }
}
