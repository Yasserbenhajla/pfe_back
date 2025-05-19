package com.pfe.projet.Service;


import com.pfe.projet.Entity.Encadrant;
import com.pfe.projet.Entity.SaveEncadrant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EncadrantService {
    ResponseEntity<?> ajouterEncadrant(SaveEncadrant model);
    Encadrant modifierEncadrant(Encadrant encadrant);
    void supprimerEncadrant (Long id);
    List<Encadrant> getAllEncadrant();
    Optional<Encadrant> getEncadrantById(Long id);
}
