package com.pfe.projet.Service;

import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Repository.DemandeStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeStageServiceImpl implements DemandeStageService{

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    @Override
    public DemandeStage ajouterDemandeStage(SaveDemandeStage model) {
        DemandeStage demande = SaveDemandeStage.toEntity(model);
        return demandeStageRepository.save(demande);
    }

    @Override
    public List<DemandeStage> getDemandeStage() {
        return demandeStageRepository.findAll();
    }
}
