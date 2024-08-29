package jv.triersistemas.primeiro_projeto.service;

import java.util.List;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface TarefaService {
	
	List<TarefaDto> getAll();
	
	TarefaDto getById(Long id);
	
	TarefaDto cadastraTarefa(TarefaDto tarefa);
	
	TarefaDto atualizaTarefa(Long id, TarefaDto tarefa);
	
	void deletaTarefa(Long id);

	void deletaTudo();
	
}
