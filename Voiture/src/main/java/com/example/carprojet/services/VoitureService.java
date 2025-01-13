package com.example.carprojet.services;


import com.example.carprojet.entities.Voiture;
import com.example.carprojet.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    private final String URL = "http://localhost:8888/SERVICE-CLIENT";

    public Voiture addVoiture(String  brand, int model, String matricule, Long clientId) {
        return voitureRepository.save(new Voiture(brand,model,matricule,clientId));
    }

    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    public Optional<Voiture> findVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    public Optional<Voiture> findVoitureByClientId(Long clientId) {
        return voitureRepository.findByClientId(clientId);
    }

    public List<Voiture> findAllVoiture() {
        return voitureRepository.findAll();
    }

}
