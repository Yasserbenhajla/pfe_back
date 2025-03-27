package com.pfe.projet.Repository;


import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    boolean existsByEmail(String email);

    Etudiant findEtudiantByEmail(String email);


}
