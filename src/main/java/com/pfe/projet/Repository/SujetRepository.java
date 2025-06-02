package com.pfe.projet.Repository;

import com.pfe.projet.Entity.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet,Long> {
    List<Sujet> findSujetByEtudiantId(Long id);
}
