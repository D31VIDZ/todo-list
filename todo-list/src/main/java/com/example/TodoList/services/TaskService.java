package com.example.TodoList.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.TodoList.entities.Task;
import com.example.TodoList.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository repository;
	
	public List<Task> getAll(){
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return repository.findAll(sort);
	}
	
	public Optional<Task> getById(Long id) throws Exception{
		
		Optional<Task> task = repository.findById(id);
		
		if(task.isEmpty()) {
			throw new Exception("tarefa nao encontrada");
		}
		
		return task;
	}
	
	public Optional<Task> getByNome(String nome) throws Exception{
		
		Optional<Task> task = repository.findByNome(nome);
		
		if(task.isEmpty()) {
			throw new Exception("tarefa nao encontrada");
		}
		
		return task;
	}
	
	public Task create(Task task) {
		return repository.save(task);
	}
	
	public Task update(Task task) {
		return this.create(task);
	}
	
	public Optional<Task> delete(Long id) throws Exception {
		repository.deleteById(id);
		return getById(id);
	}	
}