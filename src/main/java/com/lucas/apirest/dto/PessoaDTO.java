package com.lucas.apirest.dto;

import java.io.Serializable;
import java.util.List;

import com.lucas.apirest.entites.Pessoa;
import com.lucas.apirest.entites.Tarefa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String departamento;
	private int horasGastas;
	
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		departamento = obj.getDepartamento().getTitulo();
		horasGastas = getHorasGastas(obj);
	}
	
	public PessoaDTO(Pessoa obj, Integer horasGastas) {
		id = obj.getId();
		nome = obj.getNome();
		departamento = obj.getDepartamento().getTitulo();
		this.horasGastas = horasGastas;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getHorasGastas() {
		return horasGastas;
	}

	public void setHorasGastas(int horasGastas) {
		this.horasGastas = horasGastas;
	}

	public Integer getHorasGastas(Pessoa obj) {
		List<Tarefa> tarefas = obj.getTarefas();
		Integer totalHoras = 0;
		for (int i = 0; i < tarefas.size(); i++) {
			totalHoras = totalHoras + tarefas.get(i).getDuracao();
		}
		
		return totalHoras;
	}
}
