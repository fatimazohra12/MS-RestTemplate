package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeBaseH2(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client("Paul MARTIN", 34f));
			clientRepository.save(new Client("Marie DUPONT", 32f));
			clientRepository.save(new Client("Jean DURAND", 36f));
			clientRepository.save(new Client("Sophie LAMBERT", 30f));
			clientRepository.save(new Client("Pierre MOREAU", 37f));
			clientRepository.save(new Client("Claire RENAUD", 33f));
			clientRepository.save(new Client("Julien FABRE", 38f));
			clientRepository.save(new Client("Camille BERNARD", 31f));
			clientRepository.save(new Client("Lucas ROUX", 39f));
			clientRepository.save(new Client("Emma GIRARD", 35f));
			clientRepository.save(new Client("Thomas LEGRAND", 34f));
			clientRepository.save(new Client("Chloé RICHARD", 30f));
			clientRepository.save(new Client("Nicolas SIMON", 37f));
			clientRepository.save(new Client("Élise PERRIN", 33f));
			clientRepository.save(new Client("Antoine BLANC", 36f));
		};
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
