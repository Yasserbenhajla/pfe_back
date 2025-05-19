package com.pfe.projet.Service;

import com.pfe.projet.Entity.LettreAffectation;
import com.pfe.projet.Entity.LettreAffectation;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Entity.SaveLettreAffectation;
import com.pfe.projet.Repository.LettreAffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LettreAffectationServiceImpl implements LettreAffectationService{

    @Autowired
    LettreAffectationRepository lettreAffectationRepository ;

    @Override
    public LettreAffectation ajouterLettreAffectation(SaveLettreAffectation model) {
        LettreAffectation lettreAffectation = SaveLettreAffectation.toEntity(model);
        return lettreAffectationRepository.save(lettreAffectation);
    }


    @Override
    public List<LettreAffectation> getLettreAffectation() {
        return lettreAffectationRepository.findAll();
    }
}
