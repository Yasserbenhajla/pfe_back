package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RapportFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String rapportFinal;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String autorisation;

    @ManyToOne
    private Etudiant etudiant;
}
