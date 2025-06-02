package com.pfe.projet.Service;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.StageRepository;
import com.pfe.projet.Repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SujetServiceImpl implements SujetService {
    @Autowired
    SujetRepository sujetRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private StageRepository stageRepository;



    @Override
    public Sujet ajouterSujet(SaveSujet model) {
        Etudiant etudiant = etudiantRepository.findById(model.getIdEtudiant())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        Stage stage = stageRepository.findById(model.getIdStage())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));


        Sujet sujet = SaveSujet.toEntity(model, etudiant,stage);

        return sujetRepository.save(sujet);

    }

    @Override
    public Sujet modifierSujet(SaveSujet model) {
        Sujet sujet = sujetRepository.findById(model.getId())
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));

        Etudiant etudiant = etudiantRepository.findById(model.getIdEtudiant()).get();
        sujet.setEtudiant(etudiant);


        sujet.setDescription(model.getDescription());

        sujet.setEtudiant(etudiant);

        return sujetRepository.save(sujet);
    }

    @Override
    public List<Sujet> getSujet() {
        return sujetRepository.findAll();
    }

    @Override
    public ResponseEntity<?> validateSujet(ValidateSujetRq validateSujetRq) {
        Optional<Sujet> r = sujetRepository.findById(validateSujetRq.getIdSujet());
        if (r.isPresent()) {
            Sujet res = r.get();
            res.setStatus(2);
            return new ResponseEntity<>(sujetRepository.save(res), HttpStatus.OK);
        }
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> annulerSujet(Long id) {
        Optional<Sujet> optionalSujet = sujetRepository.findById(id);
        if (optionalSujet.isPresent()) {
            Sujet sujet = optionalSujet.get();
            sujet.setStatus(1);
            sujetRepository.save(sujet); // N'oubliez pas d'enregistrer
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Sujet> listeSujetByEtudiant(Long id) {
        return sujetRepository.findSujetByEtudiantId(id);
    }

}
