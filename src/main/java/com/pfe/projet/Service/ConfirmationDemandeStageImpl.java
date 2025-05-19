package com.pfe.projet.Service;

import com.pfe.projet.Entity.ConfirmationDemandeStage;
import com.pfe.projet.Entity.SaveConfirmationDemandeStage;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Repository.ConfirmationDemandeStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmationDemandeStageImpl implements ConfirmationDemandeService{

    @Autowired
    ConfirmationDemandeStageRepository confirmationDemandeStageRepository ;

    public ConfirmationDemandeStage ConfirmationDemandeStage(SaveConfirmationDemandeStage model) {
        ConfirmationDemandeStage confirmation = SaveConfirmationDemandeStage.toEntity(model);
        return confirmationDemandeStageRepository.save(confirmation);
    }


    @Override
    public List<ConfirmationDemandeStage> getConfirmationDemandeStage() {
        return confirmationDemandeStageRepository.findAll();
    }
}
