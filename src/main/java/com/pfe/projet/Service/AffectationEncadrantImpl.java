package com.pfe.projet.Service;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Repository.AffectationEncadrantRepository;
import com.pfe.projet.Repository.EncadrantRepository;
import com.pfe.projet.Repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationEncadrantImpl implements AffectationEncadrantService {
    @Autowired
    private AffectationEncadrantRepository affectationRepository;

    @Autowired
    private SujetRepository sujetRepository;

    @Autowired
    private EncadrantRepository encadrantRepository;


    @Override
    public AffectationEncadrant AffecterEncadrant(SaveAffectationEncadrant model) {
        Sujet sujet = sujetRepository.findById(model.getIdSujet()).get();

        Encadrant encadrant = encadrantRepository.findById(model.getIdEncadrant()).get();

        AffectationEncadrant affectation = SaveAffectationEncadrant.toEntity(model, sujet, encadrant);

        return affectationRepository.save(affectation);
    }

    @Override
    public List<AffectationEncadrant> getAffectationEncadrant() {
        return affectationRepository.findAll();
    }



    @Override
    public AffectationEncadrant modifierAffectationEncadrant(Long id, SaveAffectationEncadrant model) {
        AffectationEncadrant affectationExistante = affectationRepository.findById(id).get();


        Sujet sujet = sujetRepository.findById(model.getIdSujet()).get();

        Encadrant encadrant = encadrantRepository.findById(model.getIdEncadrant()).get();


        affectationExistante.setSujet(sujet);
        affectationExistante.setEncadrant(encadrant);

        return affectationRepository.save(affectationExistante);
    }




}
