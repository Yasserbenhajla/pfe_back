package com.pfe.projet.Service;

import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Repository.QualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualiteServiceImpl implements QualiteService {
    @Autowired
    private QualiteRepository qualiteRepository;

    @Override
    public Qualite ajouterQualite(Qualite qualite) {
        return qualiteRepository.save(qualite);
    }

    @Override
    public List<Qualite> getQualite() {
        return qualiteRepository.findAll();
    }

    @Override
    public Qualite modifierQualite(Qualite qualite) {

            return qualiteRepository.save(qualite);

    }

    @Override
    public Optional<Qualite> getQualiteById(Long id) {
        return qualiteRepository.findById(id);
    }
}
