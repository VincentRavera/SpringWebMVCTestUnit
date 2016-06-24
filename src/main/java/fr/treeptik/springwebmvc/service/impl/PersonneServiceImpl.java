package fr.treeptik.springwebmvc.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.springwebmvc.dao.PersonneDAO;
import fr.treeptik.springwebmvc.exception.PersonneNotFoundException;
import fr.treeptik.springwebmvc.service.PersonneService;
import fr.treeptik.springwebsample.model.Personne;

public class PersonneServiceImpl implements PersonneService {
	
	private PersonneDAO personneDAO;

	public PersonneDAO getPersonneDAO() {
		return personneDAO;
	}
	public void setPersonneDAO(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}

	@Override
	@Transactional
	public Personne save(Personne personne) {
		personne = personneDAO.save(personne);
		return personne;
	}
	@Override
	public Personne findById(Integer id) {	
		return personneDAO.findOne(id);
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		Personne personne = this.findById(id);
		if (personne ==null) {
			throw new PersonneNotFoundException("Missing Personne ...");
		}
		personneDAO.delete(personne);
		
	}
	@Override
	public List<Personne> findByName(String name) {
		List<Personne> personnes = personneDAO.findByNom(name);
		return personnes;
	}
	@Override
	public List<Personne> findAllOrderByNameDesc() {
		return personneDAO.findAllOrderByNomDesc();
	}
	@Override
	public List<Personne> findAll() {
		return personneDAO.findAll();
	}
	
	

}
