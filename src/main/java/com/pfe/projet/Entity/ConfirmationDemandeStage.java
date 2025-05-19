package com.pfe.projet.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ConfirmationDemandeStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String confirmationStage;;
}
