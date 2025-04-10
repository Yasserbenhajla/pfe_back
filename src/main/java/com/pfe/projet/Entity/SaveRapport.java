package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveRapport {
    private Long id ;
    @Lob
    @Column(columnDefinition = "LongText")
    private String rapport ;
    private Long idEtudiant;

    public static Rapport  toEntity(SaveRapport model)
    {
        if (model==null)
        {return null;}
        Rapport rapport=new Rapport();
        rapport.setId(model.getId());
        rapport.setRapport((model.getRapport()));
        return rapport;
    }
}
