package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	// Aqui só se usa dados Final. Fazemos isso aqui para
	// fingir que é um banco de dados para fins didáticos
	private static List<TarefaDto> tarefas = new ArrayList<>();
	private static Long contador = 1L;

	@Override
	public List<TarefaDto> getAll() {
		return tarefas;
	}

	public Optional<TarefaDto> findById(Long id) {
		return tarefas.stream().filter(t -> Objects.equals(id, t.getId())).findFirst();
	}

	@Override
	public Optional<TarefaDto> getById(Long id) {
		return findById(id);
	}

	@Override
	public TarefaDto cadastraTarefa(TarefaDto tarefa) {
		tarefa.setId(contador++);
		tarefas.add(tarefa);
		return tarefa;
	}

	@Override
	public TarefaDto editaTarefa(Long id, TarefaDto tarefa) {

		Optional<TarefaDto> busca = findById(id);

		if (busca.isPresent()) {
			busca.get().setTitulo(tarefa.getTitulo());
			busca.get().setDescricao(tarefa.getDescricao());
			busca.get().setCompleta(tarefa.isCompleta());
			return busca.get();
		}
		return null;
	}

	@Override
	public void deletaTarefa(@PathVariable("id") Long id) {
		tarefas.removeIf(t -> t.getId().equals(id));
	}

}
