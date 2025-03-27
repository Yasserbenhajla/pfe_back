package com.pfe.projet.RestController;


import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Etudiant;

import com.pfe.projet.Repository.EtudiantRepository;

import com.pfe.projet.Service.EtudiantService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Etudiant")
@CrossOrigin("*")
public class EtudiantRestController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantService etudiantService;
    @RequestMapping(method = RequestMethod.POST )
    ResponseEntity<?> AjouterEtudiant (@RequestBody Etudiant etudiant){
        HashMap<String, Object> response = new HashMap<>();
        if(etudiantRepository.existsByEmail(etudiant.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            etudiant.setPassword(this.bCryptPasswordEncoder.encode(etudiant.getPassword()));
            Etudiant savedUser = etudiantRepository.save(etudiant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Etudiant ModifierEtudiant(@PathVariable("id")Long id, @RequestBody Etudiant etudiant){
        etudiant.setPassword(this.bCryptPasswordEncoder.encode(etudiant.getPassword()));
        Etudiant savedUser = etudiantRepository.save(etudiant);

        Etudiant newEtudiant = etudiantService.ModifierEtudiant(etudiant);
        return newEtudiant;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void supprimerEtudiant(@PathVariable("id") Long id){
        etudiantService.supprimerEtudiant(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEtudiant(@RequestBody Etudiant etudiant) {
        System.out.println("in login-etudiant"+etudiant);
        HashMap<String, Object> response = new HashMap<>();

        Etudiant userFromDB = etudiantRepository.findEtudiantByEmail(etudiant.getEmail());
        System.out.println("userFromDB+etudiant"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "etudiant not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(etudiant.getPassword(), userFromDB.getPassword());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "etudiant not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);


                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Etudiant> getEtudiantById(@PathVariable("id") Long id){

        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(id);
        return etudiant;
    }

}
