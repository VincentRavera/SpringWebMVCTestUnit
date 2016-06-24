package fr.treeptik.springwebmvc.service;

import java.util.List;

import fr.treeptik.springwebsample.model.Personne;

public interface PersonneService {
	
	Personne save(Personne personne);
	void delete(Integer id);
	Personne findById(Integer id);
	List<Personne> findByName(String name);
	List<Personne> findAllOrderByNameDesc();
	List<Personne> findAll();

}
