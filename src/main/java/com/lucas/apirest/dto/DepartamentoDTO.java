package com.lucas.apirest.dto;

import com.lucas.apirest.entites.Departamento;

public class DepartamentoDTO {
	
	private Long id;
	private String titulo;
	private Integer qtdPessoas;
	private Integer qtdTarefas;
	
	public DepartamentoDTO() {
		
	}
	
	public DepartamentoDTO(Departamento obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.qtdPessoas = obj.getPessoas().size();
		this.qtdTarefas = obj.getTarefas().size();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Integer getQtdTarefas() {
		return qtdTarefas;
	}

	public void setQtdTarefas(Integer qtdTarefas) {
		this.qtdTarefas = qtdTarefas;
	}
	
}
