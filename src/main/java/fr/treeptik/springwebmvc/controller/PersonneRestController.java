package fr.treeptik.springwebmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.treeptik.springwebmvc.service.PersonneService;
import fr.treeptik.springwebsample.model.Personne;

@RestController
@RequestMapping("/personnes")
public class PersonneRestController {
	
	@Autowired
	private PersonneService personneService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Personne> findAllPersonnes(){
		return personneService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createPersonnes(@RequestBody Personne personne) {
		personneService.save(personne);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePersonnes(
			@RequestBody Personne personne,
			@PathVariable("id") Integer id) {
		personne.setId(id);
		personneService.save(personne);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePersonnes(@PathVariable("id") Integer id) {
		personneService.delete(id);
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Personne findPersonne(@PathVariable("id") Integer id){
		return personneService.findById(id);
	}

}
