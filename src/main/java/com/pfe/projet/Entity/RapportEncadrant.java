package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RapportEncadrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String rapportEncadrant ;
    private String description ;
    @ManyToOne
    private Etudiant etudiant ;
    @ManyToOne
    private Encadrant encadrant ;
}

