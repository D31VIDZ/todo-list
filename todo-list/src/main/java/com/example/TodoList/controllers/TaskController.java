package com.example.TodoList.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TodoList.entities.Task;
import com.example.TodoList.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll(){
		List<Task> tasks = service.getAll();
		return ResponseEntity.ok(tasks);	
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Optional<Task>> getbyNome(@PathVariable String nome) throws Exception{
		Optional<Task> tasks = service.getByNome(nome);
		return ResponseEntity.ok(tasks);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> getbyId(@PathVariable Long id) throws Exception{
		Optional<Task> tasks = service.getById(id);
		return ResponseEntity.ok(tasks);	
	}	
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody @Valid Task task){
		Task newTask = service.create(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Task> update(@RequestBody @Valid Task task){
		Task newTask = service.update(task);
		return new ResponseEntity<>(newTask, HttpStatus.UPGRADE_REQUIRED);
	}
	
	@DeleteMapping
	public ResponseEntity<Optional<Task>> delete(Long id) throws Exception{
		
		Optional<Task> task = service.getById(id);
		service.delete(id);
		return ResponseEntity.ok(task);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Task>> deleteId(@PathVariable Long id) throws Exception{
		
		Optional<Task> task = service.getById(id);
		service.delete(id);
		return ResponseEntity.ok(task);
	}
}