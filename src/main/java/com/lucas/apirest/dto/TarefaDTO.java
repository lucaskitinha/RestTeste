package com.lucas.apirest.dto;

import java.io.Serializable;
import java.time.Instant;

import com.lucas.apirest.entites.Tarefa;

public class TarefaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String descricao;
	private Instant prazo;
	private Integer duracao;
	private Long idDepartamento;
	private Long idPessoa;
	private Boolean finalizado;
	
	public TarefaDTO() {
		
	}
	
	public TarefaDTO(Tarefa tarefa) {
		id = tarefa.getId();
		titulo = tarefa.getTitulo();
		descricao = tarefa.getDescricao();
		prazo = tarefa.getPrazo();
		duracao = tarefa.getDuracao();
		finalizado = tarefa.getFinalizado();
		idDepartamento = tarefa.getDepartamento().getId();
		idPessoa = tarefa.getPessoa().getId();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getPrazo() {
		return prazo;
	}

	public void setPrazo(Instant prazo) {
		this.prazo = prazo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
}
