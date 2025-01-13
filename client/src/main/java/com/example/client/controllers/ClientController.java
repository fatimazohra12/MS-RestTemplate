package com.example.client.controllers;

import com.example.client.entities.Client;
import com.example.client.entities.Voiture;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/voiture/{clientId}")
    public Voiture getVoitureByClientId(@PathVariable Long clientId) {
        return clientService.getVoitureForClient(clientId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {
        try {
            Client client = clientService.findById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        clientService.addClient(client.getNom(),client.getAge());
        return ResponseEntity.ok("Client ajouté avec succès !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok("Client supprimé avec succès !");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Impossible de supprimer le client. " + e.getMessage());
        }
    }
}
