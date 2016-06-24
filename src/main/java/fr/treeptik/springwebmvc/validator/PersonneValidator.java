package fr.treeptik.springwebmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.springwebsample.model.Personne;

@Component
public class PersonneValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Personne.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Personne personne = (Personne) target;
		
		if (personne.getNom() == null || personne.getNom().isEmpty()) {
			errors.rejectValue("nom", "nom.empty");
		}
	}
	

}
