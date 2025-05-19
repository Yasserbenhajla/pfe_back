package com.pfe.projet.RestController;

import com.pfe.projet.Entity.*;
import com.pfe.projet.Service.RapportEncadrantService;
import com.pfe.projet.Service.RapportFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapportEncadrant")
@CrossOrigin("*")

public class RapportEncadrantRestController {

    @Autowired
    private RapportEncadrantService rapportEncadrantService;

    @PostMapping
    public RapportEncadrant ajouterRapportEncadrant(@RequestBody SaveRapportEncadrant model) {
        return rapportEncadrantService.ajouterRapportEncadrant(model);
    }

    @GetMapping
    public List<RapportEncadrant> getRapportEncadrants() {
        return rapportEncadrantService.getRapportEncadrant();
    }
    @RequestMapping("get-all-by-id-Etudiant/{id}")
    public List<RapportEncadrant> listeRapportByEtudiant(@PathVariable Long id){
        return rapportEncadrantService.listeRapportEncadrantByEtudiant(id);
        }
    }
