package com.example.carprojet.repositories;

import com.example.carprojet.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Optional<Voiture> findByClientId(Long clienId);
}
