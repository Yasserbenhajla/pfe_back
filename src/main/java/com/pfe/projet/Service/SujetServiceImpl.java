package com.pfe.projet.Service;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Repository.EncadrantRepository;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SujetServiceImpl implements SujetService{
    @Autowired
    SujetRepository sujetRepository ;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    EncadrantRepository encadrantRepository;

    @Override
    public Sujet ajouterSujet(SaveSujet model) {
        Etudiant etudiant = etudiantRepository.findById(model.getIdEtudiant())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));


        Sujet sujet = SaveSujet.toEntity(model, etudiant);

        return sujetRepository.save(sujet);

    }

    @Override
    public Sujet modifierSujet(SaveSujet model) {
        Sujet sujet = sujetRepository.findById(model.getId())
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));

        Etudiant etudiant=etudiantRepository.findById(model.getIdEtudiant()).get();
        sujet.setEtudiant(etudiant);


        sujet.setDescription(model.getDescription());
        sujet.setStatus(model.isStatus());
        sujet.setEtudiant(etudiant);

        return sujetRepository.save(sujet);
    }

    @Override
    public List<Sujet> getSujet() {
        return sujetRepository.findAll();
    }

}
