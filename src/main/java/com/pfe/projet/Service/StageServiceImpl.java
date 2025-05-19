package com.pfe.projet.Service;

import com.pfe.projet.Entity.Etudiant;
import com.pfe.projet.Entity.SaveStage;
import com.pfe.projet.Entity.Stage;
import com.pfe.projet.Entity.Type_Stage;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.StageRepository;

import com.pfe.projet.Repository.Type_StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageServiceImpl implements StageService {

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private Type_StageRepository typeStageRepository;

    @Override
    public Stage ajouterStage(SaveStage model) {
        Etudiant etudiant = etudiantRepository.findById(model.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec ID : " + model.getEtudiantId()));

        Type_Stage typeStage = typeStageRepository.findById(model.getTypeDeStageId())
                .orElseThrow(() -> new RuntimeException("Type de stage introuvable avec ID : " + model.getTypeDeStageId()));

        Stage stage = SaveStage.toEntity(model);
        stage.setEtudiant(etudiant);
        stage.setTypeDeStage(typeStage);

        return stageRepository.save(stage);
    }

    @Override
    public Stage modifierStage(Long id, SaveStage model) {
        Stage stage = stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage introuvable avec ID : " + id));

        Etudiant etudiant = etudiantRepository.findById(model.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec ID : " + model.getEtudiantId()));

        Type_Stage typeStage = typeStageRepository.findById(model.getTypeDeStageId())
                .orElseThrow(() -> new RuntimeException("Type de stage introuvable avec ID : " + model.getTypeDeStageId()));

        stage.setIntitule(model.getIntitule());
        stage.setDescription(model.getDescription());
        stage.setLieu(model.getLieu());
        stage.setPays(model.getPays());
        stage.setTechnologieOutil(model.getTechnologieOutil());
        stage.setNomEntreprise(model.getNomEntreprise());
        stage.setDateDeb(model.getDateDeb());
        stage.setDateFin(model.getDateFin());
        stage.setEtudiant(etudiant);
        stage.setTypeDeStage(typeStage);

        return stageRepository.save(stage);
    }

    @Override
    public void supprimerStage(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @Override
    public Optional<Stage> getStageById(Long id) {
        return stageRepository.findById(id);
    }
}
