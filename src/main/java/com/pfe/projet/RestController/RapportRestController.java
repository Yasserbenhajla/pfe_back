package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Rapport;
import com.pfe.projet.Entity.SaveRapport;
import com.pfe.projet.Service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapport")
@CrossOrigin("*")
public class RapportRestController {

    @Autowired
    private RapportService rapportService;

    @PostMapping
    public Rapport ajouterRapport(@RequestBody SaveRapport model) {
        return rapportService.ajouterRapport(model);
    }

    @GetMapping
    public List<Rapport> getRapports() {
        return rapportService.getRapport();
    }
}
