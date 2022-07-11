package com.lucas.apirest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.apirest.entites.Pessoa;
import com.lucas.apirest.entites.Tarefa;
import com.lucas.apirest.repositories.PessoaRepository;
import com.lucas.apirest.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private PessoaRepository repositoryPessoa;

	
	public List<Tarefa> findAll(){
		return repository.findAll();
	}
	
	public Tarefa insert(Tarefa obj) {
		return repository.save(obj);
	}
	
	public Tarefa alocar(Pessoa obj, Long id) {
		Pessoa pessoa = repositoryPessoa.getReferenceById(obj.getId());
		repositoryPessoa.save(pessoa);
		Tarefa tarefa = repository.getReferenceById(id);
		tarefa.setPessoa(pessoa);
		return repository.save(tarefa);
	}
	
	public Tarefa finalizar(Boolean finaliza, Long id) {
		Tarefa tarefa = repository.getReferenceById(id);
		tarefa.setFinalizado(finaliza);
		return repository.save(tarefa);
	}
	
	public List<Tarefa> getTarefasPendentes(){
		List<Tarefa> tarefas = repository.findAll();
		List<Tarefa> tarefasPendentes = new ArrayList<>();
		for (int i = 0; i < tarefas.size(); i++) {
			
			if(tarefas.get(i).getPessoa().getId()==null) {
				tarefasPendentes.add(tarefas.get(i));
			}
		}
		tarefasPendentes.sort(((o1, o2) -> o1.getPrazo().compareTo(o2.getPrazo())));
		
		if(tarefasPendentes.size()>3) {
			List<Tarefa> tarefasPendentes2 = new ArrayList<>();
			tarefasPendentes2.add(tarefasPendentes.get(0));
			tarefasPendentes2.add(tarefasPendentes.get(1));
			tarefasPendentes2.add(tarefasPendentes.get(2));
			
			return tarefasPendentes2;
		}else {
			return tarefasPendentes;
		}
		
		
	}

}
