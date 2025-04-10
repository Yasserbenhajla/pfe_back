package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String journal ;
    @ManyToOne
    private Etudiant etudiant ;
}
