package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Specialite;
import com.pfe.projet.Service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Specialite")
@CrossOrigin("*")
public class SpecialiteRestContoller {
    @Autowired
    private SpecialiteService specialiteService;

    @PostMapping
    public Specialite ajouterSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.ajouterSpecialite(specialite);
    }



    @GetMapping
    public List<Specialite> getAllSpecialite() {
        return specialiteService.getSpecialite();
    }
}

