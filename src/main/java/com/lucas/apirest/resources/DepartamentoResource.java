package com.lucas.apirest.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.apirest.dto.DepartamentoDTO;
import com.lucas.apirest.entites.Departamento;
import com.lucas.apirest.services.DepartamentoService;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoResource {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> findAll(){
		List<Departamento> list = service.findAll();
		List<DepartamentoDTO> listDTO = list.stream().map(x -> new DepartamentoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
