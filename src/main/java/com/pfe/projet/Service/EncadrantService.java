package com.pfe.projet.Service;


import com.pfe.projet.Entity.Encadrant;

import java.util.List;
import java.util.Optional;

public interface EncadrantService {
    Encadrant ajouterEncadrant(Encadrant encadrant);
    Encadrant modifierEncadrant(Encadrant encadrant);
    void supprimerEncadrant (Long id);
    List<Encadrant> getAllEncadrant();
    Optional<Encadrant> getEncadrantById(Long id);
}
