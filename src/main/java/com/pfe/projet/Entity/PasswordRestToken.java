package com.pfe.projet.Entity;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
public class PasswordRestToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "etudiant_id")
    private Etudiant etudiant;

    private Date expiryDate;



    public PasswordRestToken(Etudiant etudiant) {
        this.etudiant = etudiant;
        this.token = UUID.randomUUID().toString();
        this.expiryDate = calculateExpiryDate(24 * 60); // 24 hours
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return cal.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}
