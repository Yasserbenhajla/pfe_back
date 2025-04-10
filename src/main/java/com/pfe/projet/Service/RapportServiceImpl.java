package com.pfe.projet.Service;

import com.pfe.projet.Entity.Etudiant;
import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.SaveRapport;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportServiceImpl implements RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Rapport ajouterRapport(SaveRapport model) {
        Rapport rapport = SaveRapport.toEntity(model);
        Etudiant etudiant=etudiantRepository.findById(model.getIdEtudiant()).get();
        rapport.setEtudiant(etudiant);

        return  rapportRepository.save(rapport);
    }

    @Override
    public List<Rapport> getRapport() {
        return rapportRepository.findAll();
    }


}
