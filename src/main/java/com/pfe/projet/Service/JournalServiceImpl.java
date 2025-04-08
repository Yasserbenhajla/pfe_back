package com.pfe.projet.Service;

import com.pfe.projet.Entity.Etudiant;
import com.pfe.projet.Entity.Journal;
import com.pfe.projet.Entity.SaveJournal;
import com.pfe.projet.Repository.EtudiantRepository;
import com.pfe.projet.Repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalServiceImpl implements JournalService{
    @Autowired
    JournalRepository journalRepository ;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Journal ajouterJournal(SaveJournal model) {
        Journal journal=SaveJournal.toEntity(model);
        Etudiant etudiant=etudiantRepository.findById(model.getIdEtudiant()).get();
        journal.setEtudiant(etudiant);

        return  journalRepository.save(journal);
    }

    @Override
    public List<Journal> getJournal() {
        return journalRepository.findAll();
    }
}
