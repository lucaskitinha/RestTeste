package com.lucas.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.apirest.entites.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
