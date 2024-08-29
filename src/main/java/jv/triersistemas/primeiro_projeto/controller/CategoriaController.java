package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

		@Autowired
		private CategoriaService categoriaService;
	
	
		@GetMapping("/get")
		public List<CategoriaDto> getAll(){
			return categoriaService.getAll();
		}

		@GetMapping("/get/{id}")
		public CategoriaDto getById(@PathVariable("id") Long id) {
			return categoriaService.getById(id);
		}
		
		@PostMapping("/new")
		public CategoriaDto salvarCategoria(@RequestBody CategoriaDto categoriaDto) {
			return categoriaService.salvarCategoria(categoriaDto);
		}
		
		@PutMapping("/edit/{id}")
		public CategoriaDto editaCategoria(@PathVariable("id") Long id, @RequestBody CategoriaDto categoriaDto) {
			return categoriaService.atualizaCategoria(id, categoriaDto);
		}
		
		@DeleteMapping("/delete/{id}")
		public void deletaCategoria(@PathVariable Long id) {
			categoriaService.deletaCategoria(id);
		}
		
}
