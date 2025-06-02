package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description ;
    private int status=0 ;
    @ManyToOne
    private Etudiant etudiant ;
    @ManyToOne
    private Stage stage ;



}
