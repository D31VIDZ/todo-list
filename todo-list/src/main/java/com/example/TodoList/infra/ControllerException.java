package com.example.TodoList.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.TodoList.dots.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerException {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threat404(EntityNotFoundException exception) {	
		return ResponseEntity.notFound().build();
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	public ResponseEntity threatGeneral(Exception exception) {
		ExceptionDTO newExc = new ExceptionDTO(exception.getMessage(), "500");
		return ResponseEntity.internalServerError().body(newExc);
	}	
}