package jv.triersistemas.primeiro_projeto.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {
	@Autowired
	private TarefaRepository repository;	
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public List<TarefaDto> getAll() {
		List<TarefaEntity> listaTarefaEntity = repository.findAll();
		return listaTarefaEntity.stream().map(TarefaDto::new).toList();
	}

	@Override
	public TarefaDto getById(Long id) {
		return new TarefaDto(repository.findById(id).orElseThrow( () -> new NullPointerException("ID não encontrado")));
	}
 
	@Override
	public List<TarefaDto> listarTarefasIncompletasPorCategoria(Long id) {
		return repository.findAllByCompleta(false); //TODO: implementar método
	}
	
	@Override
	public TarefaDto cadastraTarefa(TarefaDto novaTarefaDto) {
		
		validaDataExpiracaoTarefa(novaTarefaDto);
		
		TarefaEntity novaTarefaEntity = new TarefaEntity(novaTarefaDto, getCategoriaEntityById(novaTarefaDto));		
		
		return new TarefaDto(repository.save(novaTarefaEntity));
	}

	public TarefaDto atualizaTarefa(Long id, TarefaDto tarefaAtualizada) {
	
		Optional<TarefaEntity> tarefaEntity = repository.findById(id);
		
		if (!tarefaEntity.isPresent()) {
			return null;
		}
		
		tarefaEntity.get()
		.atualizaTarefa(tarefaAtualizada, getCategoriaEntityById(tarefaAtualizada));
		
		var entidadePersistida = repository.save(tarefaEntity.get());
		return new TarefaDto(entidadePersistida);
	
	}
	
	@Override
	public void deletaTarefa(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

	
	@Override
	public void deletaTudo() {
		repository.deleteAll();
	}
	
	private CategoriaEntity getCategoriaEntityById(TarefaDto dto) {
		return new CategoriaEntity(categoriaService.getById(dto.getCategoriaId()));
	}
	
	private void validaDataExpiracaoTarefa(TarefaDto dto) {
		if (!dto.getDataExpiracao().isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Data de expiração deve ser maior que o dia atual");
		}
		
	}

	
}



