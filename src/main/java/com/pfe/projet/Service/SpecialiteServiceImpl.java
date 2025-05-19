package com.pfe.projet.Service;

import com.pfe.projet.Entity.Contact;
import com.pfe.projet.Entity.Specialite;
import com.pfe.projet.Repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteServiceImpl implements SpecialiteService{
    @Autowired
    SpecialiteRepository specialiteRepository ;

    @Override
    public Specialite ajouterSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public List<Specialite> getSpecialite() {
        return specialiteRepository.findAll();
    }
}
