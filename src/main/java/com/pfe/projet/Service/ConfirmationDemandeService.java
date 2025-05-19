package com.pfe.projet.Service;

import com.pfe.projet.Entity.ConfirmationDemandeStage;
import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.SaveConfirmationDemandeStage;
import com.pfe.projet.Entity.SaveDemandeStage;

import java.util.List;

public interface ConfirmationDemandeService {
    ConfirmationDemandeStage ConfirmationDemandeStage(SaveConfirmationDemandeStage model);
    List<ConfirmationDemandeStage> getConfirmationDemandeStage();
}
