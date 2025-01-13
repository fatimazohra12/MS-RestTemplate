package com.example.carprojet.entities;

import jakarta.persistence.*;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private int modele;
    private String matricule;
    @Column(unique = true)
    private Long clientId;

    public Voiture(String marque, int modele, String matricule, Long clientId) {
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.clientId = clientId;
    }

    public Voiture() {
    }

    public Long getId() {
        return this.id;
    }

    public String getmarque() {
        return this.marque;
    }

    public int getmodele() {
        return this.modele;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setmarque(String marque) {
        this.marque = marque;
    }

    public void setmodele(int modele) {
        this.modele = modele;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
