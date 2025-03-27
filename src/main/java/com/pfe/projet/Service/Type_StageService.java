package com.pfe.projet.Service;

import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Type_Stage;

import java.util.List;

public interface Type_StageService {
    Type_Stage ajouterType_stage(Type_Stage Type_stage);
    Type_Stage modifierType_Stage(Type_Stage Type_stage);
    void supprimerType_stage (Long id);
    List<Type_Stage> getAllType_stage();
}
