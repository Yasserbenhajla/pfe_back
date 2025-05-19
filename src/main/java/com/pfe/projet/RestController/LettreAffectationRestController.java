package com.pfe.projet.RestController;


import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.LettreAffectation;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Entity.SaveLettreAffectation;
import com.pfe.projet.Service.DemandeStageService;
import com.pfe.projet.Service.LettreAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lettreAffectation")
@CrossOrigin("*")
public class LettreAffectationRestController {
    @Autowired
    private LettreAffectationService lettreAffectationService;


    @PostMapping
    public LettreAffectation ajouterLettreAffectation(@RequestBody SaveLettreAffectation model) {
        return lettreAffectationService.ajouterLettreAffectation(model);
    }


    @GetMapping
    public List<LettreAffectation> getDemandes() {
        return lettreAffectationService.getLettreAffectation();
    }

}
