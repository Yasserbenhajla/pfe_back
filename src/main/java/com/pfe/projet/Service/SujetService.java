package com.pfe.projet.Service;

import com.pfe.projet.Entity.SaveSujet;
import com.pfe.projet.Entity.Sujet;
import com.pfe.projet.Entity.ValidateSujetRq;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SujetService {
    Sujet ajouterSujet(SaveSujet model);
    Sujet modifierSujet(SaveSujet model);
    List<Sujet> getSujet();

    ResponseEntity<?> validateSujet(ValidateSujetRq validateSujetRq);

    ResponseEntity<?> annulerSujet(Long id);

    List<Sujet> listeSujetByEtudiant(Long id);
}
