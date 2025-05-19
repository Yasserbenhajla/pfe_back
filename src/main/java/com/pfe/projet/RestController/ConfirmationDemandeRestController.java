package com.pfe.projet.RestController;

import com.pfe.projet.Entity.ConfirmationDemandeStage;
import com.pfe.projet.Entity.DemandeStage;
import com.pfe.projet.Entity.SaveConfirmationDemandeStage;
import com.pfe.projet.Entity.SaveDemandeStage;
import com.pfe.projet.Service.ConfirmationDemandeService;
import com.pfe.projet.Service.DemandeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Confirmation")
@CrossOrigin("*")
public class ConfirmationDemandeRestController {
    @Autowired
    private ConfirmationDemandeService confirmationDemandeService;


    @PostMapping
    public ConfirmationDemandeStage ConfirmationDemandeStage(@RequestBody SaveConfirmationDemandeStage model) {
        return confirmationDemandeService.ConfirmationDemandeStage(model);
    }


    @GetMapping
    public List<ConfirmationDemandeStage> getConfirmationDemandeStage() {
        return confirmationDemandeService.getConfirmationDemandeStage();
    }

}

