package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Entity.Qualite;
import com.pfe.projet.Service.QualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public Qualite modifierQualite(@PathVariable Long id, @RequestBody Qualite qualite) {
        qualite.setId(id);
        return qualiteService.modifierQualite(qualite);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Qualite> getQualiteById(@PathVariable("id") Long id) {

        Optional<Qualite> qualite = qualiteService.getQualiteById(id);
        return qualite;
    }
}

