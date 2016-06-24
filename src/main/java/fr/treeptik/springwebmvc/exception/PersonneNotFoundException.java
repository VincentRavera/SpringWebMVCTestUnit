package fr.treeptik.springwebmvc.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonneNotFoundException(String message) {
		super(message);
	}

}
