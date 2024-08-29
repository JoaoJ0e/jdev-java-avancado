package jv.triersistemas.primeiro_projeto.service;

import java.util.List;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;

public interface CategoriaService {


	List<CategoriaDto> getAll();
	
	CategoriaDto getById(Long id);
	
	CategoriaDto salvarCategoria(CategoriaDto categoriaDto);
	
	CategoriaDto atualizaCategoria(Long id, CategoriaDto categoriaAtualizada);
	
	void deletaCategoria(Long id);
}
