package com.pfe.projet.Repository;

import com.pfe.projet.Entity.PasswordRestToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRestTokenRepository extends JpaRepository<PasswordRestToken,Long> {
    PasswordRestToken findByToken(String token);
}
