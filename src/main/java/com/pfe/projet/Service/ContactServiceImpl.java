package com.pfe.projet.Service;

import com.pfe.projet.Entity.Contact;
import com.pfe.projet.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact ajouterContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void supprimerContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }
}
