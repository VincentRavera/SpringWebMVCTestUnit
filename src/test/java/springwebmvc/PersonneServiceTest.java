package springwebmvc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.springwebmvc.config.ApplicationConfiguration;
import fr.treeptik.springwebmvc.service.PersonneService;
import fr.treeptik.springwebsample.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
@ActiveProfiles("test")
public class PersonneServiceTest {

	private Logger logger = LoggerFactory.getLogger(PersonneServiceTest.class);

	@Autowired
	private PersonneService personneService;

	@Test
	@Transactional
	public void shouldSavePersonne() {

		try {

			Personne personne = new Personne();
			personne.setNom("Dupont");
			personne.setPrenom("Pierre");
			personne = personneService.save(personne);

			Assert.assertNotNull(personne.getId());
			Assert.assertEquals("Dupont", personne.getNom());
			Assert.assertEquals("Pierre", personne.getPrenom());

		} catch (Exception e) {
			logger.error("exception : " + e.getMessage());
			Assert.fail();
		}
	}
	@Test
	@Transactional
	public void shouldUpdatePersonne() {

		try {

			Personne personne = new Personne();
			personne.setNom("Dupont");
			personne.setPrenom("Pierre");
			personne = personneService.save(personne);

			Assert.assertNotNull(personne.getId());
			Assert.assertEquals("Dupont", personne.getNom());
			Assert.assertEquals("Pierre", personne.getPrenom());
			
			personne.setNom("Moales");
			personne.setPrenom("David");
			personne = personneService.save(personne);
			
			Assert.assertNotNull(personne.getId());
			Assert.assertEquals("Moales", personne.getNom());
			Assert.assertEquals("David", personne.getPrenom());
			

		} catch (Exception e) {
			logger.error("exception : " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	@Transactional
	public void shouldDeletePersonne() {

		try {

			Personne personne = new Personne();
			personne.setNom("Dupont");
			personne.setPrenom("Pierre");
			personne = personneService.save(personne);

			Assert.assertNotNull(personne.getId());
			Assert.assertEquals("Dupont", personne.getNom());
			Assert.assertEquals("Pierre", personne.getPrenom());
			
			Integer id = personne.getId();
			personneService.delete(id);
			personne = null;
			personne = personneService.findById(id);
			
			Assert.assertNotNull(id);
			Assert.assertNull(personne);

		} catch (Exception e) {
			logger.error("exception : " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	@Sql(scripts = "classpath:/init-test.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts="classpath:/clean.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	public void shoudFindPersonne() {
		try {
			Personne personne = personneService.findById(1);
			Assert.assertEquals("Dupuis", personne.getNom());
			Assert.assertEquals("Paul", personne.getPrenom());
		} catch (Exception e) {
			logger.error("exception : " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	@Sql(scripts = "classpath:/init-test.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts="classpath:/clean.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	public void shoudFindAllOrderByNameDesc() {
		try {
			List<Personne> personnes = personneService.findAllOrderByNameDesc();
			for (int i = 0; i < personnes.size() - 1; i++) {
				Boolean test = false;
				test = personnes.get(i).getNom().compareTo(personnes.get(i+1).getNom())>=0;
				Assert.assertTrue(test);
				
			}
		} catch (Exception e) {
			logger.error("exception : " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	@Sql(scripts = "classpath:/init-test.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts="classpath:/clean.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	public void shouldFindByName() {
		try {
			List<Personne> personnes = personneService.findByName("Dupuis");
			
			for (Personne personne : personnes) {
				Assert.assertEquals("Dupuis", personne.getNom());
			
			}
			//example boucle Lambda
			personnes.stream().forEach(p -> {Assert.assertEquals("Dupuis", p.getNom());});
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
