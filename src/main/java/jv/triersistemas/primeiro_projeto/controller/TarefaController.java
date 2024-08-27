package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public List<TarefaDto> getAll() {
		return tarefaService.getAll();
	}

	@GetMapping("/get/{id}")
	public Optional<TarefaDto> getById(@PathVariable("id") Long id) {
		return tarefaService.getById(id);
	}

	@PostMapping("/cadastrar")
	public TarefaDto cadastraTarefa(@RequestBody TarefaDto tarefa) {
		return tarefaService.cadastraTarefa(tarefa);
	}
	
	@PutMapping("/edit/{id}")
	public TarefaDto editaTarefa(@PathVariable("id")Long id, @RequestBody TarefaDto tarefa) {
		return tarefaService.editaTarefa(id, tarefa);
	}

	@DeleteMapping("/delete/{id}")
	public void deletaTarefa(@PathVariable("id") Long id) {
		tarefaService.deletaTarefa(id);
	}
	
	
}