package com.pfe.projet.RestController;



import com.pfe.projet.Entity.SaveSujet;
import com.pfe.projet.Entity.Sujet;
import com.pfe.projet.Service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujet")
@CrossOrigin("*")
public class SujetRestController {
    @Autowired
    private SujetService sujetService;

    @PostMapping
    public Sujet ajouterSujet(@RequestBody SaveSujet model) {
        return sujetService.ajouterSujet(model);
    }

    @PutMapping
    public Sujet modifierSujet(@RequestBody SaveSujet model) {
        return sujetService.modifierSujet(model);
    }

    @GetMapping
    public List<Sujet> getSujet() {
        return sujetService.getSujet();
    }
}
