package com.pfe.projet.Repository;

import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.RapportEncadrant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RapportEncadrantRepository extends JpaRepository<RapportEncadrant,Long> {
    List<RapportEncadrant> findByEtudiantId(Long id);
}
