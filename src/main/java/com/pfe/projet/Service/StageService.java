package com.pfe.projet.Service;

import com.pfe.projet.Entity.SaveStage;
import com.pfe.projet.Entity.Stage;

import java.util.List;
import java.util.Optional;

public interface StageService {
    Stage ajouterStage(SaveStage model);
    Stage modifierStage(Long id, SaveStage model);
    void supprimerStage(Long id);
    List<Stage> getAllStages();
    Optional<Stage> getStageById(Long id);
}
