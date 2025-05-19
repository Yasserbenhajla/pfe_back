package com.pfe.projet.RestController;

import com.pfe.projet.Entity.SaveStage;
import com.pfe.projet.Entity.Stage;
import com.pfe.projet.Service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stage")
@CrossOrigin("*")
public class StageRestController {

    @Autowired
    private StageService stageService;

    @PostMapping
    public ResponseEntity<Stage> ajouterStage(@RequestBody SaveStage model) {
        Stage nouveauStage = stageService.ajouterStage(model);
        return ResponseEntity.ok(nouveauStage);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Stage> modifierStage(@PathVariable Long id, @RequestBody SaveStage model) {
        Stage updatedStage = stageService.modifierStage(id, model);
        return ResponseEntity.ok(updatedStage);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerStage(@PathVariable Long id) {
        stageService.supprimerStage(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        return ResponseEntity.ok(stageService.getAllStages());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Stage> getStageById(@PathVariable Long id) {
        Optional<Stage> stage = stageService.getStageById(id);
        return stage.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
