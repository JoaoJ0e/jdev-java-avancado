package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.ErrorResponseDto;
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
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(tarefaService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
		}
	}

	@PostMapping("/cadastrar")
	public TarefaDto cadastraTarefa(@RequestBody TarefaDto tarefa) {
		return tarefaService.cadastraTarefa(tarefa);
	}
	
	@PutMapping("/edit/{id}")
	public TarefaDto editaTarefa(@PathVariable("id")Long id, @RequestBody TarefaDto tarefa) {
			return tarefaService.atualizaTarefa(id, tarefa);			
	}

	@DeleteMapping("/delete/{id}")
	public void deletaTarefa(@PathVariable("id") Long id) {
		tarefaService.deletaTarefa(id);
	}
	
	@DeleteMapping("/delete/all")
	public void deletaTudo() {
		tarefaService.deletaTudo();
	}
	
	
}