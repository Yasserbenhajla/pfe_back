package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String sujet;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String message;
}
