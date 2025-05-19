package com.pfe.projet.Service;

import com.pfe.projet.Entity.Etudiant;
import com.pfe.projet.Entity.PasswordRestToken;
import com.pfe.projet.Repository.AdminRepository;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.PasswordRestTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    PasswordRestTokenRepository passwordRestTokenRepository;
    @Autowired
    EmailService emailService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant ModifierEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> forgotPassword(String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email);

        if (etudiant == null) {
            return ResponseEntity.badRequest().body("Aucun utilisateur trouvé avec cet email");
        }

        PasswordRestToken resetToken = new PasswordRestToken(etudiant);
        passwordRestTokenRepository.save(resetToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("manaamoataz@gmail.com");
        mailMessage.setTo(etudiant.getEmail());
        mailMessage.setSubject("Réinitialisation du mot de passe");
        mailMessage.setText("Pour réinitialiser votre mot de passe, cliquez sur ce lien : "
                + "http://localhost:4200/reset-password?token=" + resetToken.getToken());

        emailService.sendEmail(mailMessage);

        return ResponseEntity.ok("Le lien de réinitialisation du mot de passe a été envoyé à votre adresse e-mail.");
    }

    @Override
    public ResponseEntity<?> resetPassword(String token, String newPassword) {
        PasswordRestToken resetToken = passwordRestTokenRepository.findByToken(token);

        if (resetToken == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        if (resetToken.getExpiryDate().before(new Date())) {
            return ResponseEntity.badRequest().body("Token has expired");
        }

        Etudiant etudiant = resetToken.getEtudiant();
        etudiant.setPassword(bCryptPasswordEncoder.encode(newPassword));
        etudiantRepository.save(etudiant);

        passwordRestTokenRepository.delete(resetToken);

        return ResponseEntity.ok("Le mot de passe a été réinitialisé avec succès");
    }

}

