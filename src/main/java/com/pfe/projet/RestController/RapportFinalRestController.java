package com.pfe.projet.RestController;


import com.pfe.projet.Entity.RapportFinal;

import com.pfe.projet.Entity.SaveRapportFinal;
import com.pfe.projet.Service.RapportFinalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapportFinal")
@CrossOrigin("*")

public class RapportFinalRestController {
    @Autowired
    private RapportFinalService rapportFinalService;

    @PostMapping
    public RapportFinal ajouterRapportFinal(@RequestBody SaveRapportFinal model) {
        return rapportFinalService.ajouterRapportFinal(model);
    }

    @GetMapping
    public List<RapportFinal> getRapportFinals() {
        return rapportFinalService.getRapportFinal();
    }
}
