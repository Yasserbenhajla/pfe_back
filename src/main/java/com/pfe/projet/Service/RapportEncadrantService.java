package com.pfe.projet.Service;

import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.RapportEncadrant;
import com.pfe.projet.Entity.SaveRapportEncadrant;


import java.util.List;

public interface RapportEncadrantService {
    RapportEncadrant ajouterRapportEncadrant(SaveRapportEncadrant model);
    List<RapportEncadrant> getRapportEncadrant();
    List<RapportEncadrant> listeRapportEncadrantByEtudiant(Long id);
}
