package com.pfe.projet.Service;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Repository.EncadrantRepository;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.RapportFinalRepository;
import com.pfe.projet.Repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportFinalServiceImpl implements RapportFinalService {

    @Autowired
    private RapportFinalRepository rapportFinalRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public RapportFinal ajouterRapportFinal(SaveRapportFinal model) {
        RapportFinal rapport = SaveRapportFinal.toEntity(model);
        Etudiant etudiant=etudiantRepository.findById(model.getIdEtudiant()).get();
        rapport.setEtudiant(etudiant);


        return  rapportFinalRepository.save(rapport);
    }

    @Override
    public List<RapportFinal> getRapportFinal() {

        return rapportFinalRepository.findAll();
    }

}


