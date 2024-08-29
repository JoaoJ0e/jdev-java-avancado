package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<CategoriaDto> getAll() {
		List<CategoriaEntity> listaCategoriaEntity = categoriaRepository.findAll();
		return listaCategoriaEntity.stream().map(CategoriaDto::new).toList();
	}

	@Override
	public CategoriaDto getById(Long id) {
		return new CategoriaDto(categoriaRepository.findById(id).orElse(null));
	}
	
	@Override
	public CategoriaDto salvarCategoria(CategoriaDto categoriaDto) {
		CategoriaEntity entidadePersistida = categoriaRepository.save(new CategoriaEntity(categoriaDto));
		return new CategoriaDto(entidadePersistida);
	}

	@Override
	public CategoriaDto atualizaCategoria(Long id, CategoriaDto categoriaAtualizada) {
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
		
		if (categoriaEntity.isEmpty()) {
			return null;
		}
		
		categoriaEntity.get().atualizaCategoria(categoriaAtualizada);
		var entidadePersistida = categoriaRepository.save(categoriaEntity.get());
		return new CategoriaDto(entidadePersistida);
		
	}

	@Override
	public void deletaCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}
	
}
