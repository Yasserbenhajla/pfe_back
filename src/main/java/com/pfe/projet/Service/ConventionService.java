package com.pfe.projet.Service;

import com.pfe.projet.Entity.Convention;

import java.util.List;

public interface ConventionService {
    Convention ajouterConvention(Convention convention);
    List<Convention> getAllConvention();
}
