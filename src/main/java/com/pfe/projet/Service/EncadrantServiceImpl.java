package com.pfe.projet.Service;

import com.pfe.projet.Entity.Encadrant;
import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Entity.SaveEncadrant;
import com.pfe.projet.Entity.Specialite;
import com.pfe.projet.Repository.EncadrantRepository;
import com.pfe.projet.Repository.QualiteRepository;
import com.pfe.projet.Repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EncadrantServiceImpl implements EncadrantService{
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EncadrantRepository encadrantRepository ;
    @Autowired
    SpecialiteRepository specialiteRepository;
    @Autowired
    QualiteRepository qualiteRepository;
    @Override
    public ResponseEntity<?> ajouterEncadrant(SaveEncadrant model) {
        Encadrant encadrant = SaveEncadrant.toEntity(model);

        Specialite specialite= specialiteRepository.findById(model.getIdSpecialite()).get();
        encadrant.setSpecialite(specialite);


        Qualite qualite= qualiteRepository.findById(model.getIdQualite()).get();
        encadrant.setQualite(qualite);


        encadrant.setPassword(this.bCryptPasswordEncoder.encode(encadrant.getPassword()));
        Encadrant saved=encadrantRepository.save(encadrant);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public Encadrant modifierEncadrant(Encadrant encadrant) {
        return encadrantRepository.save(encadrant);
    }

    @Override
    public void supprimerEncadrant(Long id) {
    encadrantRepository.deleteById(id);
    }

    @Override
    public List<Encadrant> getAllEncadrant() {
        return encadrantRepository.findAll();
    }

    @Override
    public Optional<Encadrant> getEncadrantById(Long id) {
        return encadrantRepository.findById(id);
    }
}
