package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    private String description;
    private String lieu;
    private String pays;
    private String technologieOutil;
    private String nomEntreprise ;
    private Date dateDeb;
    private Date dateFin;

    @ManyToOne
    private Type_Stage typeDeStage;
    @ManyToOne
    private Etudiant etudiant ;



}
