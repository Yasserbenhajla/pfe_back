package com.pfe.projet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveJournal {
    private Long id ;
    @Lob
    @Column(columnDefinition = "LongText")
    private String journal ;
    private Long idEtudiant;

    public static Journal toEntity(SaveJournal model)
    {
        if (model==null)
        {return null;}
        Journal journal=new Journal();
        journal.setId(model.getId());
        journal.setJournal((model.getJournal()));
        return journal;
    }
}
