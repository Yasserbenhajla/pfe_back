package com.pfe.projet.Service;

import com.pfe.projet.Entity.AffectationEncadrant;
import com.pfe.projet.Entity.RapportEncadrant;
import com.pfe.projet.Entity.SaveAffectationEncadrant;

import java.util.List;

public interface AffectationEncadrantService {
    AffectationEncadrant AffecterEncadrant(SaveAffectationEncadrant model);
    List<AffectationEncadrant> getAffectationEncadrant();
    AffectationEncadrant modifierAffectationEncadrant(Long id, SaveAffectationEncadrant model);

}
