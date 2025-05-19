package com.pfe.projet.Service;


import com.pfe.projet.Entity.LettreAffectation;
import com.pfe.projet.Entity.SaveLettreAffectation;

import java.util.List;

public interface LettreAffectationService {
    LettreAffectation ajouterLettreAffectation(SaveLettreAffectation model);
    List<LettreAffectation> getLettreAffectation();
}
