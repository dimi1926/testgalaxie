package fr.education.candidats;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import fr.education.candidats.entity.Candidat;

@SpringBootApplication(scanBasePackages = {"fr.education.candidats"})
@EntityScan(basePackages = { "fr.education.candidats.entity" })
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
		// afficher l'URL pour effectuer un test via un navigateur.
		System.out.println("http://localhost:8080/ws");
		
					
	}

}