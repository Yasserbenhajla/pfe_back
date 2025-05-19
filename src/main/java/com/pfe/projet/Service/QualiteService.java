package com.pfe.projet.Service;

import com.pfe.projet.Entity.Qualite;

import java.util.List;

public interface QualiteService {
    Qualite ajouterQualite(Qualite qualite);
    List<Qualite> getQualite();
}
