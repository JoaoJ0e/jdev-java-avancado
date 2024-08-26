package jv.triersistemas.primeiro_projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/tarefa-controller")
public class TarefaController {

	private static List<Tarefa> tarefas = new ArrayList<>();
	Integer contador = 0;

	@GetMapping("/get-all")
	public List<Tarefa> getAll() {
		return tarefas;
	}

	@GetMapping("/get-by-id")
	public Tarefa getById(@RequestBody Integer id) {
		return tarefas.stream()
		.filter(tarefa -> id == tarefa.getId())
		.findAny()
		.orElse(null);
	}

	@PostMapping("/cadastra-tarefa")
	public void cadastraTarefa(@RequestBody Tarefa tarefa) {
		contador += 1;
		tarefa.defineId(contador);
		tarefas.add(tarefa);
	}
	
	@PutMapping("/edita-tarefa")
	public void editaTarefa(@RequestBody Tarefa tarefa) {
		tarefas.set((tarefas.indexOf(tarefas.stream()
				.filter(item -> tarefa.getId() == item.getId())
				.findAny()
				.orElse(null))), tarefa);
	}

	@DeleteMapping("/deleta-tarefa")
	public void deletaTarefa(@RequestBody Integer id) {
		tarefas.remove(
				tarefas.indexOf
				(tarefas.stream()
				.filter(item -> id == item.getId())
				.findAny()
				.orElse(null)));
	}
}

@NoArgsConstructor
@Getter
class Tarefa {
	
	private long id;
	private String titulo;
	private String descricao;
	private boolean completa;

	public Tarefa(String titulo, String descricao, boolean completa) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.completa = completa;
	}

	protected void defineId(int id) {
		this.id = id;
	}
}