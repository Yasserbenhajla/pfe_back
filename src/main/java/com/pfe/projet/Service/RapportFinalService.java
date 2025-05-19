package com.pfe.projet.Service;

import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.RapportFinal;
import com.pfe.projet.Entity.SaveRapport;
import com.pfe.projet.Entity.SaveRapportFinal;

import java.util.List;

public interface RapportFinalService {
    RapportFinal ajouterRapportFinal(SaveRapportFinal model);
    List<RapportFinal> getRapportFinal();
}

