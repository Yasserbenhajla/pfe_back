package com.pfe.projet.Repository;

import com.pfe.projet.Entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
