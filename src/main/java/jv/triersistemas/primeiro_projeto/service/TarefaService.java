package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface TarefaService {
	
	List<TarefaDto> getAll();
	
	TarefaDto getById(Long id);
	
	TarefaDto cadastraTarefa(TarefaDto tarefa);
	
	ResponseEntity<?> editaTarefa(Long id, TarefaDto tarefa);
	
	void deletaTarefa(Long id);
	
}
