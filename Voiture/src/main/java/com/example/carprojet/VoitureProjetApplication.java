package com.example.carprojet;

import com.example.carprojet.entities.Voiture;
import com.example.carprojet.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;

@EnableDiscoveryClient
@SpringBootApplication
public class VoitureProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureProjetApplication.class, args);
	}
	@Bean
	CommandLineRunner initializeBaseH2(VoitureRepository voitureRepository){
		return args -> {
			String[] marques = {"Range Rover", "Peugeot", "Renault",  "Ford", "Volkswagen", "Range Rover","Audi", "Mercedes", "Hyundai",
					"Nissan", "Jeep", "Volvo",  "Tesla", "Range Rover"};

			IntStream.rangeClosed(1, marques.length).forEach(i -> {
				String voitureMarque = marques[(i - 1) % marques.length];
				String voitureModel = voitureMarque + " Model " + (i % 16 + 3);
				int voitureYear = 2000 + (i % 24);
				String voiturePlate = String.format("FRANCE-%03d-%02d", i, (i % 99) + 1);
				voitureRepository.save(new Voiture(voitureModel, voitureYear, voiturePlate, Long.valueOf(i)));
			});

		};
	}
}
