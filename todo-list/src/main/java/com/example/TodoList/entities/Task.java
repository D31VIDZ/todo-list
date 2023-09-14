package com.example.TodoList.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "nome em branco")
	private String nome;
	
	@NotBlank(message = "descrição em branco")
	private String descricao;
	
	private boolean realizado = false;
	
	@Max(5)
	@Min(1)
	private int prioridade;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(@NotBlank(message = "nome em branco") String nome,
			@NotBlank(message = "descrição em branco") String descricao, @Max(5) @Min(1) int prioridade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
}
