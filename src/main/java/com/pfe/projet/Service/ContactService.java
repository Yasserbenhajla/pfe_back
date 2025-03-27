package com.pfe.projet.Service;

import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Contact;

import java.util.List;

public interface ContactService {
    Contact ajouterContact(Contact contact);
    void supprimerContact (Long id);
    List<Contact> getAllContact();
}
