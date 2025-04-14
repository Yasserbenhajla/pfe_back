package com.pfe.projet.RestController;


import com.pfe.projet.Entity.Convention;
import com.pfe.projet.Repository.ConventionRepository;
import com.pfe.projet.Service.ConventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/convention")
@CrossOrigin("*")
public class ConventionRestController {
    @Autowired
    ConventionRepository conventionRepository;
    @Autowired
    ConventionService conventionService;
    @RequestMapping(method = RequestMethod.POST )
    public Convention AjouterConvention (@RequestBody Convention convention){
        return conventionService.ajouterConvention(convention);
    }


    @RequestMapping(method = RequestMethod.GET )
    public List<Convention> getAllConvention(){
        return conventionService.getAllConvention();

    }
}
