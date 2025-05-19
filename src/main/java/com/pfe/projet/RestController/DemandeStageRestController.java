package com.pfe.projet.RestController;

import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Service.DemandeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/demandeStage")
@CrossOrigin("*")


public class DemandeStageRestController {
    @Autowired
    private DemandeStageService demandeStageService;


    @PostMapping
    public DemandeStage ajouterDemandeStage(@RequestBody SaveDemandeStage model) {
        return demandeStageService.ajouterDemandeStage(model);
    }


    @GetMapping
    public List<DemandeStage> getDemandes() {
        return demandeStageService.getDemandeStage();
    }

}
