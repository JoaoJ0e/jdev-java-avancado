package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface TarefaService {
	
	List<TarefaDto> getAll();
	
	Optional<TarefaDto> getById(Long id);
	
	TarefaDto cadastraTarefa(TarefaDto tarefa);
	
	TarefaDto editaTarefa(Long id, TarefaDto tarefa);
	
	void deletaTarefa(Long id);
	
}
