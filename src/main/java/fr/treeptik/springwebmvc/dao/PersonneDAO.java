package fr.treeptik.springwebmvc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.springwebsample.model.Personne;

public interface PersonneDAO extends JpaRepository<Personne, Integer> {
	
	@Query("SELECT p FROM Personne p WHERE p.nom=:nom")
	List<Personne> findByNom2(@Param("nom") String nom) throws DataAccessException;
	
	List<Personne> findByNom(String nom) throws DataAccessException;

	@Query("SELECT p FROM Personne p ORDER BY p.nom DESC")
	List<Personne> findAllOrderByNomDesc() throws DataAccessException;
	
	List<Personne> findAll() throws DataAccessException;

}
