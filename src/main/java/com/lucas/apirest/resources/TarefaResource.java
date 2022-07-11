package com.lucas.apirest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.apirest.dto.TarefaDTO;
import com.lucas.apirest.entites.Pessoa;
import com.lucas.apirest.entites.Tarefa;
import com.lucas.apirest.services.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll(){
		List<Tarefa> list = service.findAll();
		List<TarefaDTO> listDTO = list.stream().map(x -> new TarefaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@RequestBody Tarefa obj){
		obj = service.insert(obj);
		TarefaDTO objDTO = new TarefaDTO(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(objDTO);
	}
	
	@PutMapping(value = "alocar/{id}")
	public ResponseEntity<TarefaDTO> alocarPessoa(@RequestBody Pessoa obj, @PathVariable Long id){
		Tarefa tarefa = service.alocar(obj, id);
		TarefaDTO tarefaDTO = new TarefaDTO(tarefa);
		return ResponseEntity.ok().body(tarefaDTO);
	
	}
	
	@PutMapping(value = "finalizar/{id}")
	public ResponseEntity<TarefaDTO> finalizarTarefa(@RequestBody Tarefa obj, @PathVariable Long id){
		Tarefa tarefa = service.finalizar(obj.getFinalizado(), id);
		TarefaDTO tarefaDTO = new TarefaDTO(tarefa);
		return ResponseEntity.ok().body(tarefaDTO);
		
	}
	
	@GetMapping(value = "/pendentes")
	public ResponseEntity<List<TarefaDTO>> getTarefasPendentes(){
		List<Tarefa> list = service.getTarefasPendentes();
		List<TarefaDTO> listDTO = list.stream().map(x -> new TarefaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
}
