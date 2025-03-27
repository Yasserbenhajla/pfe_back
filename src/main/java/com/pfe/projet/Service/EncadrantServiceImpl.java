package com.pfe.projet.Service;

import com.pfe.projet.Entity.Encadrant;
import com.pfe.projet.Repository.EncadrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EncadrantServiceImpl implements EncadrantService{
    @Autowired
    EncadrantRepository encadrantRepository ;
    @Override
    public Encadrant ajouterEncadrant(Encadrant encadrant) {
        return encadrantRepository.save(encadrant);
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
