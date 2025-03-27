package com.pfe.projet.Service;

import com.pfe.projet.Entity.Encadrant;
import com.pfe.projet.Entity.Type_Stage;
import com.pfe.projet.Repository.Type_StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Type_StageImpl implements Type_StageService{
    @Autowired
    Type_StageRepository typeStageRepository;


    @Override
    public Type_Stage ajouterType_stage(Type_Stage typeStage) {
        return typeStageRepository.save(typeStage);
    }

    @Override
    public Type_Stage modifierType_Stage(Type_Stage Type_stage) {

        return typeStageRepository.save(Type_stage);
    }



    @Override
    public void supprimerType_stage(Long id) {
        typeStageRepository.deleteById(id);
    }


    @Override
    public List<Type_Stage> getAllType_stage() {
        return typeStageRepository.findAll();
    }
}
