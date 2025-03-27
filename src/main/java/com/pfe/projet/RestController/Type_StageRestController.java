package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Encadrant;
import com.pfe.projet.Entity.Type_Stage;
import com.pfe.projet.Service.Type_StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type_stage")
public class Type_StageRestController {

    @Autowired
     Type_StageService typeStageService;

    @PostMapping
    public Type_Stage ajouterType_Stage(@RequestBody Type_Stage typeStage) {
        return typeStageService.ajouterType_stage(typeStage);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Type_Stage modifierType_Stage(@PathVariable("id")Long id, @RequestBody Type_Stage type_stage){
        Type_Stage newType_stage = typeStageService.modifierType_Stage(type_stage);
        return newType_stage;
    }

    @DeleteMapping("/{id}")
    public void supprimerType_stage(@PathVariable("id") Long id) {
        typeStageService.supprimerType_stage(id);
    }

    @GetMapping
    public List<Type_Stage> getAllType_stage() {
        return typeStageService.getAllType_stage();
    }
}
