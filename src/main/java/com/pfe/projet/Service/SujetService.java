package com.pfe.projet.Service;

import com.pfe.projet.Entity.SaveSujet;
import com.pfe.projet.Entity.Sujet;

import java.util.List;

public interface SujetService {
    Sujet ajouterSujet(SaveSujet model);
    Sujet modifierSujet(SaveSujet model);
    List<Sujet> getSujet();
}
