package com.pfe.projet.Service;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.RapportEncadrantRepository;
import com.pfe.projet.Repository.RapportFinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportEncadranrServiceImpl implements RapportEncadrantService {
    @Autowired
    private RapportEncadrantRepository rapportEncadrantRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public RapportEncadrant ajouterRapportEncadrant(SaveRapportEncadrant model) {
        RapportEncadrant rapportEncadrant = SaveRapportEncadrant.toEntity(model);
        Etudiant etudiant = etudiantRepository.findById(model.getIdEtudiant()).get();
        rapportEncadrant.setEtudiant(etudiant);


        return rapportEncadrantRepository.save(rapportEncadrant);
    }

    @Override
    public List<RapportEncadrant> getRapportEncadrant() {

        return rapportEncadrantRepository.findAll();
    }

    @Override
    public List<RapportEncadrant> listeRapportEncadrantByEtudiant(Long id) {
        return rapportEncadrantRepository.findByEtudiantId(id);
    }

}