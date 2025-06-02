package com.pfe.projet.RestController;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.projet.Entity.Admin;
import com.pfe.projet.Entity.Etudiant;

import com.pfe.projet.Repository.EtudiantRepository;

import com.pfe.projet.Service.EmailEnServiceImpl;
import com.pfe.projet.Service.EmailService;
import com.pfe.projet.Service.EtudiantService;
import com.pfe.projet.Service.RestMdpService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/Etudiant")
@CrossOrigin("*")
public class EtudiantRestController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
@Autowired
    RestMdpService restMdpService ;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantService etudiantService;
    @Autowired
    EmailEnServiceImpl emailEnService;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterEtudiant(@RequestBody Etudiant etudiant) {
        HashMap<String, Object> response = new HashMap<>();
        if (etudiantRepository.existsByEmail(etudiant.getEmail())) {
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            etudiant.setPassword(this.bCryptPasswordEncoder.encode(etudiant.getPassword()));
            Etudiant savedUser = etudiantRepository.save(etudiant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public void supprimerEtudiant(@PathVariable("id") Long id) {
        etudiantService.supprimerEtudiant(id);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEtudiant(@RequestBody Etudiant etudiant) {
        System.out.println("in login-etudiant" + etudiant);
        HashMap<String, Object> response = new HashMap<>();

        Etudiant userFromDB = etudiantRepository.findEtudiantByEmail(etudiant.getEmail());
        System.out.println("userFromDB+etudiant" + userFromDB);
        if (userFromDB == null) {
            response.put("message", "etudiant not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(etudiant.getPassword(), userFromDB.getPassword());
            System.out.println("compare" + compare);
            if (!compare) {
                response.put("message", "etudiant not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);


                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Etudiant> getEtudiantById(@PathVariable("id") Long id) {

        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(id);
        return etudiant;
    }


    private static final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/tokeninfo?id_token=";

    @PostMapping("/login-google")
    public ResponseEntity<Map<String, Object>> loginWithGoogle(@RequestParam("id_token") String idToken) {
        Map<String, Object> response = new HashMap<>();
        try {
            String googleUserInfo = validateGoogleToken(idToken);
            JsonNode userInfo = new ObjectMapper().readTree(googleUserInfo);

            String email = userInfo.get("email").asText();
            String fullName = userInfo.get("name").asText();
            String firstName = fullName.split(" ")[0]; // Prenons le prénom comme étant la première partie du nom complet
            String lastName = fullName.split(" ").length > 1 ? fullName.split(" ")[1] : ""; // Nom de famille s'il existe

            Etudiant existingEtudiant = etudiantRepository.findEtudiantByEmail(email);

            if (existingEtudiant == null) {

                Etudiant newEtudiant = new Etudiant();
                newEtudiant.setEmail(email);
                newEtudiant.setNom(lastName); // Nom
                newEtudiant.setPrenom(firstName); // Prénom
                newEtudiant.setPassword("defaultPassword"); // Mot de passe temporaire, à changer plus tard
                newEtudiant.setEtat(true);  // Statut actif

                etudiantRepository.save(newEtudiant);
                existingEtudiant = newEtudiant;
            }

            String token = generateToken(existingEtudiant);
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            response.put("message", "Erreur lors du traitement du token Google : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            response.put("message", "Une erreur inconnue est survenue.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    private String validateGoogleToken(String idToken) {
        String url = GOOGLE_TOKEN_URL + idToken;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    private String generateToken(Etudiant client) {
        return Jwts.builder()
                .claim("data", client)
                .signWith(SignatureAlgorithm.HS256, "SECRET_KEY")
                .compact();
    }

    @RequestMapping(value = "/forgotmdp", method = RequestMethod.POST)
    public ResponseEntity<?> forgotMdp(@RequestBody Etudiant etudiant) {
        System.out.println("Demande de réinitialisation de mot de passe reçue pour l'e-mail: " + etudiant);
        Etudiant userFromDB = etudiantRepository.findByEmail(etudiant.getEmail());
        if (userFromDB == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
        } else {
            String nvmdp = restMdpService.nvMdp();
            userFromDB.setPassword(bCryptPasswordEncoder.encode(nvmdp));
            etudiantRepository.save(userFromDB);

            emailEnService.SendSimpleMessage(etudiant.getEmail(), "Votre nouveau mot de passe", "Bonjour,\n" +
                    "Votre mot de passe été re-initlaisé, le nouveau mot de passe est : " + nvmdp);
            return ResponseEntity.status(HttpStatus.OK).body("Instructions de réinitialisation du mot de passe envoyées à votre adresse e-mail");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> modifieretudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        Etudiant newEtudiant= null;
        HashMap<String, Object> response = new HashMap<>();
        if(etudiantRepository.findById(id).isPresent()) {
            Etudiant etudiant1 = etudiantRepository.findById(id).get();
            var etudiantid = etudiant.getId();
            var nom = etudiant.getNom();
            var prenom = etudiant.getPrenom();
            var email = etudiant.getEmail();
            var password = etudiant.getPassword();
            var niveau = etudiant.getNiveau();
            var tel = etudiant.getTel();


            etudiant1.setId(etudiantid);
            etudiant1.setNom(nom);
            etudiant1.setPrenom(prenom);
            etudiant1.setEmail(email);
            etudiant1.setPassword(password);
            etudiant1.setNiveau(niveau);
            etudiant1.setTel(tel);


            etudiant.setPassword(this.bCryptPasswordEncoder.encode(etudiant.getPassword()));

            newEtudiant = etudiantRepository.save(etudiant1);

            String token = Jwts.builder()
                    .claim("data", newEtudiant)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();

            response.put("client", newEtudiant);
            response.put("token", token);
            System.out.println("ddddddddddddd");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("message", "Etudiant not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }
}