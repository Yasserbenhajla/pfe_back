package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AffectationEncadrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
    private Sujet sujet ;
    @ManyToOne
    private Encadrant encadrant ;


}

