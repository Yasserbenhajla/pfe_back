package com.pfe.projet.Service;


import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.SaveRapport;

import java.util.List;

public interface RapportService {
    Rapport ajouterRapport(SaveRapport model);
    List<Rapport> getRapport();
}


