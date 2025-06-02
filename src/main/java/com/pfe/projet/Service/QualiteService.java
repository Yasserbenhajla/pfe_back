package com.pfe.projet.Service;

import com.pfe.projet.Entity.Qualite;


import java.util.List;
import java.util.Optional;

public interface QualiteService {
    Qualite ajouterQualite(Qualite qualite);
    List<Qualite> getQualite();
    Qualite modifierQualite(Qualite qualite);
    Optional<Qualite> getQualiteById(Long id);
}
