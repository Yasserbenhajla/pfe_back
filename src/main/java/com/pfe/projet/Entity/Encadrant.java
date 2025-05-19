package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Encadrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String tel;
    @ManyToOne
    private Qualite qualite;
    @ManyToOne
    private Specialite specialite;


}
