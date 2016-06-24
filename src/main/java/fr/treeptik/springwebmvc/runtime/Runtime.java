package fr.treeptik.springwebmvc.runtime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.treeptik.springwebsample.model.Personne;

public class Runtime {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Personne[]> entity = restTemplate.getForEntity("http://localhost:8080/springwebmvc/personnes", Personne[].class);
		for (Personne per : entity.getBody()) {
			System.out.println(per.getNom());
		}
	}

}
