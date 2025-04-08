package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Journal;
import com.pfe.projet.Entity.SaveJournal;
import com.pfe.projet.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/journal")
@RestController
@CrossOrigin("*")

public class JournalRestController {
    @Autowired
    JournalService journalService;
    @RequestMapping(method = RequestMethod.POST )
    public Journal AjouterJournal (@RequestBody SaveJournal model){
        return journalService.ajouterJournal(model);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Journal> getJournal(){
        return journalService.getJournal();

    }
}
