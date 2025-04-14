package com.pfe.projet.Service;

import com.pfe.projet.Entity.Convention;
import com.pfe.projet.Repository.ConventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConventionServiceImpl implements ConventionService{
    @Autowired
    ConventionRepository conventionRepository;
    @Override
    public Convention ajouterConvention(Convention convention) {
        return conventionRepository.save(convention);
    }

    @Override
    public List<Convention> getAllConvention() {
        return conventionRepository.findAll();
    }
}
