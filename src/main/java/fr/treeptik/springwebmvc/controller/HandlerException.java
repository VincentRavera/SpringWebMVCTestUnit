package fr.treeptik.springwebmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.treeptik.springwebmvc.dto.JsonError;
import fr.treeptik.springwebmvc.exception.PersonneNotFoundException;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(value={DataAccessException.class, PersonneNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void hadleDataAccessEcxeption(HttpServletResponse response, Exception e) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonError error = new JsonError();
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setMessage("Missing Personne ...!");
		String messerror = objectMapper.writeValueAsString(error);
		response.getWriter().println(messerror);
	}
	
	
	

}
