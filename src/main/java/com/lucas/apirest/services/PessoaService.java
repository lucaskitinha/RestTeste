package com.lucas.apirest.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.apirest.dto.PessoaDTO;
import com.lucas.apirest.entites.Pessoa;
import com.lucas.apirest.entites.Tarefa;
import com.lucas.apirest.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}
	
	public Pessoa update(Long id, Pessoa obj) {
		Pessoa pessoa = repository.getReferenceById(id);
		updateData(pessoa, obj);
		return repository.save(pessoa);
	}
	
	private void updateData(Pessoa pessoa, Pessoa obj) {
		pessoa.setNome(obj.getNome());
		pessoa.setDepartamento(obj.getDepartamento());
		
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public PessoaDTO horasGastasPorPeriodo(String nome, String dataInicio, String dataFinal) {
		Pessoa pessoa = repository.findByNome(nome);
		List<Tarefa> tarefas = pessoa.getTarefas();
		Instant dataInicioInstant = Instant.parse(dataInicio);
		Instant dataFinalInstant = Instant.parse(dataFinal);
		Integer horasTotal = 0;
		
		for (int i = 0; i < tarefas.size(); i++) {
			if(tarefas.get(i).getPrazo().compareTo(dataInicioInstant)>=0 
			&& tarefas.get(i).getPrazo().compareTo(dataFinalInstant)<=0 ) {
				horasTotal = horasTotal + tarefas.get(i).getDuracao();
			}
		}
		
		PessoaDTO pessoaDTO = new PessoaDTO(pessoa, horasTotal);
		return pessoaDTO;
	}
}
