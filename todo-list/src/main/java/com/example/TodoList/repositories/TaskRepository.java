package com.example.TodoList.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoList.entities.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	public Optional<Task> findByNome(String nome);
}