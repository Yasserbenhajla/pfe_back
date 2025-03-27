package com.pfe.projet.Service;

import com.pfe.projet.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin ajouterAdmin(Admin admin);
    Admin modifierAdmin(Admin admin);
    void supprimerAdmin (Long id);
    List<Admin> getAllAdmin();
    Optional<Admin> getAdminById(Long id);
}
