package com.pfe.projet.Service;

import com.pfe.projet.Entity.Journal;
import com.pfe.projet.Entity.SaveJournal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JournalService {
    Journal ajouterJournal(SaveJournal model);
    List<Journal> getJournal();
}
