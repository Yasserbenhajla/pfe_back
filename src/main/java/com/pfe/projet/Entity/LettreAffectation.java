package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LettreAffectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String lettreAffectation;;
}
