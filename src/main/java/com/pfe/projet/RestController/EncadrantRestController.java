package com.pfe.projet.RestController;


import com.pfe.projet.Entity.Encadrant;

import com.pfe.projet.Repository.EncadrantRepository;

import com.pfe.projet.Service.EncadrantService;
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
@RequestMapping(value = "/Encadrant")
@CrossOrigin("*")
public class EncadrantRestController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EncadrantRepository encadrantRepository;

    @Autowired
    EncadrantService encadrantService;
    @RequestMapping(method = RequestMethod.POST )
    ResponseEntity<?> AjouterEncadrant (@RequestBody Encadrant encadrant){
        HashMap<String, Object> response = new HashMap<>();
        if(encadrantRepository.existsByEmail(encadrant.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            encadrant.setPassword(this.bCryptPasswordEncoder.encode(encadrant.getPassword()));
            Encadrant savedUser = encadrantRepository.save(encadrant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Encadrant modifierEncadrant(@PathVariable("id")Long id, @RequestBody Encadrant encadrant){
        encadrant.setPassword(this.bCryptPasswordEncoder.encode(encadrant.getPassword()));
        Encadrant savedUser = encadrantRepository.save(encadrant);
        Encadrant newEncadrant = encadrantService.modifierEncadrant(encadrant);
        return newEncadrant;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void supprimerEncadrant(@PathVariable("id") Long id){
        encadrantService.supprimerEncadrant(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Encadrant> getAllEncadrant(){
        return encadrantService.getAllEncadrant();

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEncadrant(@RequestBody Encadrant encadrant) {
        System.out.println("in login-encadrant"+encadrant);
        HashMap<String, Object> response = new HashMap<>();

        Encadrant userFromDB = encadrantRepository.findEncadrantByEmail(encadrant.getEmail());
        System.out.println("userFromDB+encadrant"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "encadrant not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(encadrant.getPassword(), userFromDB.getPassword());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "encadrant not found !");
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
    public Optional<Encadrant> getEncadrantById(@PathVariable("id") Long id){

        Optional<Encadrant> encadrant = encadrantService.getEncadrantById(id);
        return encadrant;
    }

}
