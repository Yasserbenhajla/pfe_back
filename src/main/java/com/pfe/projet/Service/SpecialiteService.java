package com.pfe.projet.Service;

import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Entity.Specialite;
import com.pfe.projet.Entity.Sujet;

import java.util.List;
import java.util.Optional;

public interface SpecialiteService {
    Specialite ajouterSpecialite(Specialite specialite);
    List<Specialite> getSpecialite();
    Specialite modifierSpecialite(Specialite specialite);


}
