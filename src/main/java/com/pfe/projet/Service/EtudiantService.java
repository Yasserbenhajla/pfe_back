package com.pfe.projet.Service;

import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    Etudiant ajouterEtudiant(Etudiant etudiant);
    Etudiant ModifierEtudiant(Etudiant etudiant);
    void supprimerEtudiant (Long id);
    List<Etudiant> getAllEtudiant();
    Optional<Etudiant> getEtudiantById(Long id);
    ResponseEntity<?> forgotPassword(String email);
    ResponseEntity<?> resetPassword(String token, String newPassword);
}
