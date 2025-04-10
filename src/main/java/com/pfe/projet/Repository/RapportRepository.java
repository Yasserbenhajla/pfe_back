package com.pfe.projet.Repository;

import com.pfe.projet.Entity.Journal;
import com.pfe.projet.Entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport, Long> {
}
