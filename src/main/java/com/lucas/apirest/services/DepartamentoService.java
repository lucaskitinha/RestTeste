package com.lucas.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.apirest.entites.Departamento;
import com.lucas.apirest.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public List<Departamento> findAll(){
		return repository.findAll();
	}
}
