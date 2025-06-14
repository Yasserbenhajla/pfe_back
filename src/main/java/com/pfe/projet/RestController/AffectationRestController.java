package com.pfe.projet.RestController;

import com.pfe.projet.Entity.AffectationEncadrant;
import com.pfe.projet.Entity.RapportEncadrant;
import com.pfe.projet.Entity.SaveAffectationEncadrant;
import com.pfe.projet.Service.AffectationEncadrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("affectation")
@CrossOrigin(origins = "*")

public class AffectationRestController {
    @Autowired
    private AffectationEncadrantService affectationService;


    @PostMapping
    public AffectationEncadrant affecterEncadrant(@RequestBody SaveAffectationEncadrant model) {
        return affectationService.AffecterEncadrant(model);
    }


    @GetMapping
    public List<AffectationEncadrant> getAllAffectations() {
        return affectationService.getAffectationEncadrant();
    }




    @PutMapping("/{id}")
    public AffectationEncadrant modifierAffectation(
            @PathVariable Long id,
            @RequestBody SaveAffectationEncadrant model) {
        return affectationService.modifierAffectationEncadrant(id, model);
    }
    @RequestMapping("get-all-by-id-Enc/{id}")
    public List<AffectationEncadrant> listeAffectationByEncadrant(@PathVariable Long id){
        return affectationService.listeAffectationByEncadrant(id);
    }
}
