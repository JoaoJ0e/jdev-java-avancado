package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	// Aqui só se usa dados Final. Fazemos isso aqui para
	// fingir que é um banco de dados para fins didáticos
	private static List<TarefaDto> tarefas = new ArrayList<>();

	@Autowired
	private TarefaRepository repository;	
	
	@Override
	public List<TarefaDto> getAll() {
		
		List<TarefaEntity> listaEntity = repository.findAll();
		List<TarefaDto> listaDto = new ArrayList<>();
		
		for (TarefaEntity tarefaEntity : listaEntity) {
			listaDto.add(new TarefaDto(tarefaEntity));
		}
		
		return listaDto;
	}

	@Override
	public TarefaDto getById(Long id) {
		return new TarefaDto(repository.findById(id).orElseThrow( () -> new NullPointerException("ID não encontrado")));
	}

	@Override
	public TarefaDto cadastraTarefa(TarefaDto novaTarefaDto) {
		TarefaEntity tarefaEntity = new TarefaEntity(novaTarefaDto);
		TarefaEntity entidadePersistida = repository.save(tarefaEntity);
		return new TarefaDto(entidadePersistida);
	}

	@Override
	public ResponseEntity<?> editaTarefa(Long id, TarefaDto tarefa) {

		TarefaEntity tarefaEntity = repository.findById(id).orElse(null);
		
		if (tarefaEntity == null) {
			throw new NullPointerException("ID não encontrado");
		}
		
		tarefaEntity.setTitulo(tarefa.getTitulo());
		tarefaEntity.setDescricao(tarefa.getDescricao());
		tarefaEntity.setCompleta(tarefa.getCompleta());
		
		repository.save(tarefaEntity);
		
		return ResponseEntity.ok(new TarefaDto(tarefaEntity));
		
		/*
		Optional<TarefaDto> busca = getById(id);

		if (busca.isPresent()) {
			busca.get().setTitulo(tarefa.getTitulo());
			busca.get().setDescricao(tarefa.getDescricao());
			busca.get().setCompleta(tarefa.getCompleta());
			return busca.get();
		}
		return null;
		*/
	}

	@Override
	public void deletaTarefa(@PathVariable("id") Long id) {
		tarefas.removeIf(t -> t.getId().equals(id));
	}

}
