package com.pfe.projet.Repository;

import com.pfe.projet.Entity.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EncadrantRepository extends JpaRepository<Encadrant,Long> {
    boolean existsByEmail(String email);

    Optional<Encadrant> findByEmail(String email);

    Encadrant findEncadrantByEmail(String email);
}
