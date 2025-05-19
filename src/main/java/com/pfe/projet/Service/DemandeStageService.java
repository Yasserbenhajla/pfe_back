package com.pfe.projet.Service;

import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Entity.SaveRapport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeStageService   {
    DemandeStage ajouterDemandeStage(SaveDemandeStage model);
    List<DemandeStage> getDemandeStage();
}

