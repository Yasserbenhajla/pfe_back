package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Contact;
import com.pfe.projet.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping(value = "/contact")
@CrossOrigin("*")
public class ContactRestController {
    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.POST )
    public Contact  AjouterContcat (@RequestBody Contact contact){
      return contactService.ajouterContact(contact);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void suppContact(@PathVariable("id") Long id){
        contactService.supprimerContact(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Contact> getAllContact(){
        return contactService.getAllContact();

    }
}
