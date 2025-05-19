package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Service.QualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Qualite")
@CrossOrigin(origins = "*")
public class QualiteRestController {

    @Autowired
    private QualiteService qualiteService;

    @PostMapping
    public Qualite ajouterQualite(@RequestBody Qualite qualite) {
        return qualiteService.ajouterQualite(qualite);
    }


    @GetMapping
    public List<Qualite> getQualites() {
        return qualiteService.getQualite();
    }
}
