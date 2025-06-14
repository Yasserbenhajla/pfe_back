package com.pfe.projet.Repository;

import com.pfe.projet.Entity.AffectationEncadrant;
import com.pfe.projet.Entity.RapportEncadrant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationEncadrantRepository extends JpaRepository<AffectationEncadrant, Long> {

    List<AffectationEncadrant> findByEncadrantId(Long id);
}
