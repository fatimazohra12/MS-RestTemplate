package com.example.carprojet.controllers;
import com.example.carprojet.entities.Voiture;
import com.example.carprojet.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @PostMapping
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        Voiture savedVoiture = voitureService.addVoiture(voiture.getmarque(),voiture.getmodele(),voiture.getMatricule(),voiture.getClientId());
        return ResponseEntity.ok(savedVoiture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voiture> findVoitureById(@PathVariable Long id) {
        Optional<Voiture> voiture = voitureService.findVoitureById(id);
        if (voiture.isPresent()) {
            return ResponseEntity.ok(voiture.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("client")
    public ResponseEntity<Voiture> findVoitureByClientId(@RequestParam Long clientId) {
        Optional<Voiture> voiture = voitureService.findVoitureByClientId(clientId);
        if (voiture.isPresent()) {
            return ResponseEntity.ok(voiture.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Voiture>> findAllCars() {
        List<Voiture> voitures = voitureService.findAllVoiture();
        return ResponseEntity.ok(voitures); // Retourne la liste des voitures avec un statut 200 OK
    }
}
